package io.github.Ital023.Ecommerce_FBR_MySQL.service;

import io.github.Ital023.Ecommerce_FBR_MySQL.controller.dto.CreateUserDto;
import io.github.Ital023.Ecommerce_FBR_MySQL.entities.BillingAddressEntity;
import io.github.Ital023.Ecommerce_FBR_MySQL.entities.UserEntity;
import io.github.Ital023.Ecommerce_FBR_MySQL.repository.BillingAddressRepository;
import io.github.Ital023.Ecommerce_FBR_MySQL.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BillingAddressRepository billingAddressRepository;


    public UserService(UserRepository userRepository, BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public UserEntity createUser(CreateUserDto dto) {

        var billingAddress = new BillingAddressEntity();
        billingAddress.setAddress(dto.address());
        billingAddress.setComplement(dto.complement());
        billingAddress.setNumber(dto.number());
        var savedBillingAddress = billingAddressRepository.save(billingAddress);

        var user = new UserEntity();
        user.setFullName(dto.fullName());
        user.setBillingAddress(savedBillingAddress);

        return userRepository.save(user);
    }

    public Optional<UserEntity> findById(UUID userId) {
        return userRepository.findById(userId);
    }


    public boolean deleteById(UUID userId) {
        var user = userRepository.findById(userId);
        if(user.isPresent()) {
            userRepository.deleteById(userId);
            billingAddressRepository.deleteById(user.get().getBillingAddress().getBillingAddressId());
        }
        return user.isPresent();
    }


}
