package io.github.Ital023.Ecommerce_FBR_MySQL.controller;

import io.github.Ital023.Ecommerce_FBR_MySQL.controller.dto.CreateOrderDto;
import io.github.Ital023.Ecommerce_FBR_MySQL.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
