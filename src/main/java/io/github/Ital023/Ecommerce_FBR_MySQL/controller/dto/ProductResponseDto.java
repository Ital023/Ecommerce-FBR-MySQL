package io.github.Ital023.Ecommerce_FBR_MySQL.controller.dto;

import io.github.Ital023.Ecommerce_FBR_MySQL.entities.ProductEntity;
import io.github.Ital023.Ecommerce_FBR_MySQL.entities.TagEntity;

import java.util.List;

public record ProductResponseDto(Long productId,
                                 String productName,
                                 List<TagResponseDto> tags) {

    public static ProductResponseDto fromEntity(ProductEntity entity) {
        return new ProductResponseDto(
                entity.getProductId(),
                entity.getProductName(),
                getTags(entity.getTags())
        );
    }

    private static List<TagResponseDto> getTags(List<TagEntity> tags) {
        return tags.stream()
                .map(TagResponseDto::FromEntity)
                .toList();
    }

}
