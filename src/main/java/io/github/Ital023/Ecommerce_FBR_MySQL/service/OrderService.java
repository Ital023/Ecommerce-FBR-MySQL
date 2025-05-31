package io.github.Ital023.Ecommerce_FBR_MySQL.service;

import io.github.Ital023.Ecommerce_FBR_MySQL.controller.dto.CreateOrderDto;
import io.github.Ital023.Ecommerce_FBR_MySQL.controller.dto.OrderItemDto;
import io.github.Ital023.Ecommerce_FBR_MySQL.entities.*;
import io.github.Ital023.Ecommerce_FBR_MySQL.exception.CreateOrderException;
import io.github.Ital023.Ecommerce_FBR_MySQL.repository.OrderRepository;
import io.github.Ital023.Ecommerce_FBR_MySQL.repository.ProductRepository;
import io.github.Ital023.Ecommerce_FBR_MySQL.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(UserRepository userRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    public OrderEntity createOrder(CreateOrderDto dto) {
        var order = new OrderEntity();
        // 1. Validate User
        var user = validateUser(dto);
        // 2. Validate Order Items
        var orderItems = validateOrderItems(order, dto);
        // 3. Calculate order total
        var total = calculateOrderTotal(orderItems);
        // 4. Map to entity
        order.setOrderDate(LocalDateTime.now());
        order.setUser(user);
        order.setItems(orderItems);
        order.setTotal(total);
        // 5. Repository new
        return orderRepository.save(order);

    }

    private BigDecimal calculateOrderTotal(List<OrderItemEntity> items) {
        return items
                .stream()
                .map(i -> i.getSalePrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private List<OrderItemEntity> validateOrderItems(OrderEntity order, CreateOrderDto dto) {
        if(dto.items().isEmpty()) {
            throw new CreateOrderException("Items are empty");
        }

        return dto.items()
                .stream()
                .map(orderItemDto -> getOrderItem(order, orderItemDto))
                .toList();

    }

    private OrderItemEntity getOrderItem(OrderEntity order, OrderItemDto orderItemDto) {
        var orderItemEntity = new OrderItemEntity();
        var id = new OrderItemId();
        var product = getProduct(orderItemDto.productId());

        id.setOrder(order);
        id.setProduct(product);

        orderItemEntity.setId(id);
        orderItemEntity.setQuantity(orderItemDto.quantity());
        orderItemEntity.setSalePrice(product.getPrice());

        return orderItemEntity;
    }

    private ProductEntity getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new CreateOrderException("product not found"));
    }

    private UserEntity validateUser(CreateOrderDto dto) {
        return userRepository.findById(dto.userId()).orElseThrow(() -> new CreateOrderException("user not found"));
    }


}
