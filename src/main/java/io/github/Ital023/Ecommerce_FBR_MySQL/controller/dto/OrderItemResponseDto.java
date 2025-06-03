package io.github.Ital023.Ecommerce_FBR_MySQL.controller.dto;

import io.github.Ital023.Ecommerce_FBR_MySQL.entities.OrderItemEntity;

import java.math.BigDecimal;

public record OrderItemResponseDto(BigDecimal salePrice,
                                   Integer quantity,
                                   ProductResponseDto product) {

    public static OrderItemResponseDto fromEntity(OrderItemEntity entity) {
        return new OrderItemResponseDto(
                entity.getSalePrice(),
                entity.getQuantity(),
                ProductResponseDto.fromEntity(entity.getId().getProduct())
        );
    }

}
