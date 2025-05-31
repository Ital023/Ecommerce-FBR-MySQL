package io.github.Ital023.Ecommerce_FBR_MySQL.repository;

import io.github.Ital023.Ecommerce_FBR_MySQL.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
