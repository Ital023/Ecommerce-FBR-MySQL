package io.github.Ital023.Ecommerce_FBR_MySQL.controller.dto;

import io.github.Ital023.Ecommerce_FBR_MySQL.entities.OrderEntity;
import io.github.Ital023.Ecommerce_FBR_MySQL.entities.OrderItemEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderResponseDto(Long orderId,
                               BigDecimal total,
                               LocalDateTime orderDate,
                               UUID user,
                               List<OrderItemResponseDto> items) {

    public static OrderResponseDto fromEntity(OrderEntity entity) {
        return new OrderResponseDto(
                entity.getOrderId(),
                entity.getTotal(),
                entity.getOrderDate(),
                entity.getUser().getUserId(),
                getItems(entity.getItems())
        );
    }

    private static List<OrderItemResponseDto> getItems(List<OrderItemEntity> items) {
        return items.stream()
                .map(OrderItemResponseDto::fromEntity)
                .toList();
    }


}
