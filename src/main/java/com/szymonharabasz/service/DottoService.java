package com.szymonharabasz.service;

import com.szymonharabasz.api.DottoInput;
import com.szymonharabasz.entities.Dotto;
import com.szymonharabasz.entities.Tag;
import com.szymonharabasz.entities.UserDottos;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class DottoService {
    public List<Dotto> create(String userId, DottoInput dottoInput) {
        var userDottos = UserDottos.findByUserId(userId);
        List<Dotto> dottos = userDottos.getDottos();
        Dotto dotto = new Dotto()
                .withId(UUID.randomUUID().toString())
                .createdAt(LocalDateTime.now())
                .withTitle(dottoInput.getTitle())
                .withDescription(dottoInput.getDescription())
                .withScore(dottoInput.getScore())
                .withTags(dottoInput.getTags());
        dottos.add(dotto);
        userDottos.persist();
        return getDottosForUser(userId);
    }

    public List<Dotto> getDottosForUser(String userId) {
        var userDottos = UserDottos.findByUserId(userId);
        return userDottos.getDottos();
    }

    public List<Dotto> addTag(String userId, String dottoId, Tag tag) {
        var userDottos = UserDottos.findByUserId(userId);
        List<Dotto> dottos = userDottos.getDottos();
        Optional<Dotto> dotto = dottos.stream().filter(d -> d.getId().equals(dottoId)).findFirst();
        dotto.ifPresent(d -> d.getTags().add(tag));
        userDottos.update();
        return getDottosForUser(userId);
    }
}

