package com.logan.sneaker.domain.sneaker.repos;

import com.logan.sneaker.domain.sneaker.models.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SneakerRepo extends JpaRepository<Sneaker, Long> {
    Optional<Sneaker> findByEmail(String email);

}
