package com.szymonharabasz.api;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class DottoInput {
    String title;
    String description;
    @Min(0) @Max(5)
    Integer rating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
