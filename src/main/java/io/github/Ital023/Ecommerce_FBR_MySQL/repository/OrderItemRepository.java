package io.github.Ital023.Ecommerce_FBR_MySQL.repository;

import io.github.Ital023.Ecommerce_FBR_MySQL.entities.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {

}
