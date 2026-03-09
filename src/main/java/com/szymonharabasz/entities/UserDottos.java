package com.szymonharabasz.entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.List;

public class UserDottos extends PanacheMongoEntity {
    private final String userId;
    private final List<Dotto> dottos;

    public UserDottos(String userId, List<Dotto> dottos) {
        this.userId = userId;
        this.dottos = dottos;
    }

    public String getUserId() {
        return userId;
    }

    public List<Dotto> getDottos() {
        return dottos;
    }

    public static UserDottos findByUserId(String userId) {
        return find("userId", userId).firstResult();
    }
}
