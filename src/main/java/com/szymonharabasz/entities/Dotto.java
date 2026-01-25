package com.szymonharabasz.entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;

public class Dotto extends PanacheMongoEntity {
    String title;
    String description;
    String userId;
    @Min(0) @Max(5)
    Integer rating;
    LocalDateTime createdAt;

    public Dotto withTitle(String title) {
        this.title = title;
        return this;
    }

    public Dotto withDescription(String description) {
        this.description = description;
        return this;
    }

    public Dotto withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Dotto withRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public Dotto createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getRating() {
        return rating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
