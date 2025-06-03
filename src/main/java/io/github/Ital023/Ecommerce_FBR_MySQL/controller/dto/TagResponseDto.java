package io.github.Ital023.Ecommerce_FBR_MySQL.controller.dto;

import io.github.Ital023.Ecommerce_FBR_MySQL.entities.TagEntity;

public record TagResponseDto(Long tagId,
                             String name) {

    public static TagResponseDto FromEntity(TagEntity entity) {
        return new TagResponseDto(entity.getTagId(), entity.getName());
    }

}
