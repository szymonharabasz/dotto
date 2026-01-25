package com.szymonharabasz.service;

import com.szymonharabasz.api.DottoInput;
import com.szymonharabasz.entities.Dotto;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;

@ApplicationScoped
public class DottoService {
    public Dotto create(DottoInput dottoInput) {
        Dotto dotto = new Dotto()
                .createdAt(LocalDateTime.now())
                .withTitle(dottoInput.getTitle())
                .withDescription(dottoInput.getDescription())
                .withRating(dottoInput.getRating())
                .withUserId("1");
        dotto.persist();
        return dotto;
    }
}
