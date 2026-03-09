package com.szymonharabasz.api;

import com.szymonharabasz.entities.Tag;

import java.time.LocalDateTime;
import java.util.List;

public record DottoOutput(
        String id,
        String title,
        String description,
        Integer score,
        LocalDateTime createdAt,
        List<Tag> tags
) {}
