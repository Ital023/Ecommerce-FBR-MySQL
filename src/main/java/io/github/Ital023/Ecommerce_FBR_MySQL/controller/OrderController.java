package io.github.Ital023.Ecommerce_FBR_MySQL.controller;

import io.github.Ital023.Ecommerce_FBR_MySQL.controller.dto.*;
import io.github.Ital023.Ecommerce_FBR_MySQL.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderDto dto) {
        var order = orderService.createOrder(dto);

        return ResponseEntity.created(URI.create("/orders/" + order.getOrderId())).build();
    }

    @GetMapping
    public ResponseEntity<ApiResponse<OrderSummaryDto>> listOrders(@RequestParam(name = "page",defaultValue = "0") Integer page,
                                                                   @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {

        var ordersResponse = orderService.findAll(page, pageSize);
        var paginationResponse =
                new PaginationResponse(ordersResponse.getNumber(),
                        ordersResponse.getSize(),
                        ordersResponse.getTotalElements(),
                        ordersResponse.getTotalPages()
                );

        var response = new ApiResponse<OrderSummaryDto>(ordersResponse.getContent(), paginationResponse);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDto> listOrders(@PathVariable("orderId") Long orderId) {

        var order = orderService.findById(orderId);

        return order.isPresent() ?
                ResponseEntity.ok(OrderResponseDto.fromEntity(order.get())) :
                ResponseEntity.notFound().build();
    }

}
