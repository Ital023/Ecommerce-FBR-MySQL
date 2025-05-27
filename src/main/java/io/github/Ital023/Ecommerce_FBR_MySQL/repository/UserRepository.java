package io.github.Ital023.Ecommerce_FBR_MySQL.repository;


import io.github.Ital023.Ecommerce_FBR_MySQL.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
