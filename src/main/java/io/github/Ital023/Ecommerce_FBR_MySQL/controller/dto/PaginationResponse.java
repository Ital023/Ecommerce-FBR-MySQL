package io.github.Ital023.Ecommerce_FBR_MySQL.controller.dto;

public record PaginationResponse(Integer page,
                                 Integer pageSize,
                                 Long totalElements,
                                 Integer totalPages) {
}
