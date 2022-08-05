package com.logan.sneaker.domain.sneaker.services;


import com.logan.sneaker.domain.core.ResourceCreationException;
import com.logan.sneaker.domain.core.ResourceNotFoundException;
import com.logan.sneaker.domain.sneaker.models.Sneaker;
import com.logan.sneaker.domain.sneaker.repos.SneakerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SneakerServiceImpl implements SneakerService {
    private SneakerRepo sneakerRepo;

    @Autowired
    public SneakerServiceImpl(SneakerRepo sneakerRepo) {
        this.sneakerRepo = sneakerRepo;
    }

    @Override
    public Sneaker create(Sneaker sneaker) throws ResourceCreationException {
        Optional<Sneaker> optional = sneakerRepo.findByEmail(sneaker.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Sneakerhead with email exists:" + sneaker.getEmail());
        sneaker = sneakerRepo.save(sneaker);
        return sneaker;
    }

    @Override
    public Sneaker getById(Long id) throws ResourceNotFoundException {
        Sneaker sneaker = sneakerRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Sneakerhead with id: " + id));
        return sneaker;
    }

    @Override
    public Sneaker getByEmail(String email) throws ResourceNotFoundException {
        Sneaker sneaker = sneakerRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No Sneakerhead with email: " + email));
        return sneaker;
    }

    @Override
    public List<Sneaker> getAll() {
        return sneakerRepo.findAll();
    }

    @Override
    public Sneaker update(Long id, Sneaker sneakerDetail) throws ResourceNotFoundException {
        Sneaker sneaker = getById(id);
        sneaker.setFirstName(sneakerDetail.getFirstName());
        sneaker.setLastName(sneakerDetail.getLastName());
        sneaker.setEmail(sneakerDetail.getEmail());
        sneaker = sneakerRepo.save(sneaker);
        return sneaker;
    }

    @Override
    public void delete(Long id) {
        Sneaker sneaker = getById(id);
        sneakerRepo.delete(sneaker);
    }
}
