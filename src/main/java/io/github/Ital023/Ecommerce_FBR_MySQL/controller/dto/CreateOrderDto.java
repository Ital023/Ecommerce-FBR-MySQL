package io.github.Ital023.Ecommerce_FBR_MySQL.controller.dto;

import java.util.List;
import java.util.UUID;

public record CreateOrderDto(UUID userId,
                             List<OrderItemDto> items) {
}
