package io.github.Ital023.Ecommerce_FBR_MySQL.repository;

import io.github.Ital023.Ecommerce_FBR_MySQL.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
