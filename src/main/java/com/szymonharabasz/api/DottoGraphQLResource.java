package com.szymonharabasz.api;

import com.szymonharabasz.entities.Dotto;
import com.szymonharabasz.service.DottoService;
import org.eclipse.microprofile.graphql.*;

import java.util.List;

@GraphQLApi
public class DottoGraphQLResource {

    DottoService dottoService;

    public DottoGraphQLResource(DottoService dottoService) {
        this.dottoService = dottoService;
    }

    @Query
    @Description("Say hello")
    public String sayHello(@DefaultValue("World") String name) {
        return "Hello " + name;
    }

    @Mutation
    public List<DottoOutput> create(String userId, DottoInput dottoInput) {
        List<Dotto> dottos = dottoService.create(userId, dottoInput);
        return dottos.stream().map(dotto -> new DottoOutput(
                dotto.getId(),
                dotto.getTitle(),
                dotto.getDescription(),
                dotto.getScore(),
                dotto.getCreatedAt(),
                dotto.getTags()
        )).toList();
    }
}