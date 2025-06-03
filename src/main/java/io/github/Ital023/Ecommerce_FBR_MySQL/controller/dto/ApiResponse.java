package io.github.Ital023.Ecommerce_FBR_MySQL.controller.dto;

import java.util.List;

public record ApiResponse<T>(List<T> data, PaginationResponse pagination) {
}
