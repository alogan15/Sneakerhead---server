package com.logan.sneaker.domain.sneaker.services;

import com.logan.sneaker.domain.core.ResourceCreationException;
import com.logan.sneaker.domain.core.ResourceNotFoundException;
import com.logan.sneaker.domain.sneaker.models.Sneaker;

import java.util.List;

public interface SneakerService {
    Sneaker create(Sneaker sneaker) throws ResourceCreationException;
    Sneaker getById(Long id) throws ResourceNotFoundException;
    Sneaker getByEmail(String email) throws ResourceNotFoundException;
    List<Sneaker> getAll();
    Sneaker update(Long id, Sneaker sneakerDetail) throws ResourceNotFoundException;
    void delete(Long id);
}


