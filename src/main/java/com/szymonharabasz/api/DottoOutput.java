package com.szymonharabasz.api;

import java.time.LocalDateTime;

public record DottoOutput(
        String id,
        String title,
        String description,
        String userId,
        Integer rating,
        LocalDateTime createdAt
) {}
