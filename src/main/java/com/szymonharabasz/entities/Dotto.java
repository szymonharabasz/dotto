package com.szymonharabasz.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;
import java.util.List;

public class Dotto {
    String id;
    String title;
    String description;
    @Min(0) @Max(10)
    Integer score;
    LocalDateTime createdAt;
    List<Tag> tags;

    public Dotto withId(String id) {
        this.id = id;
        return this;
    }

    public Dotto withTitle(String title) {
        this.title = title;
        return this;
    }

    public Dotto withDescription(String description) {
        this.description = description;
        return this;
    }

    public Dotto withScore(Integer score) {
        this.score = score;
        return this;
    }

    public Dotto withTags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public Dotto createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getScore() {
        return score;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Tag> getTags() {
        return tags;
    }
}
