package com.szymonharabasz.api;

import com.szymonharabasz.entities.Dotto;
import com.szymonharabasz.service.DottoService;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.*;

@GraphQLApi
public class DottoGraphQLResource {

    @Inject
    DottoService dottoService;

    @Query
    @Description("Say hello")
    public String sayHello(@DefaultValue("World") String name) {
        return "Hello " + name;
    }

    @Mutation
    public DottoOutput create(DottoInput dottoInput) {
        Dotto newDotto = dottoService.create(dottoInput);
        return new DottoOutput(
                newDotto.id.toString(),
                newDotto.getTitle(),
                newDotto.getDescription(),
                newDotto.getUserId(),
                newDotto.getRating(),
                newDotto.getCreatedAt()
        );
    }
}