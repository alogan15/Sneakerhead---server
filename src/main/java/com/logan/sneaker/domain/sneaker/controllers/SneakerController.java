package com.logan.sneaker.domain.sneaker.controllers;

import com.logan.sneaker.domain.sneaker.models.Sneaker;
import com.logan.sneaker.domain.sneaker.services.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/sneakers")
public class SneakerController {

    private SneakerService sneakerService;

    @Autowired
    public SneakerController(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }

    @GetMapping
    public ResponseEntity<List<Sneaker>> getAll() {
        List<Sneaker> sneakers = sneakerService.getAll();
        return new ResponseEntity<>(sneakers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sneaker> create(@RequestBody Sneaker sneaker) {
        sneaker = sneakerService.create(sneaker);
        return new ResponseEntity<>(sneaker, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Sneaker> getById(@PathVariable("id") Long id) {
        Sneaker sneaker = sneakerService.getById(id);
        return new ResponseEntity<>(sneaker, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<Sneaker> getByEmail(@RequestParam String email) {
        Sneaker sneaker = sneakerService.getByEmail(email);
        return new ResponseEntity<>(sneaker, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Sneaker> update(@PathVariable("id") Long id, @RequestBody Sneaker sneakerDetail) {
        sneakerDetail = sneakerService.update(id, sneakerDetail);
        return new ResponseEntity<>(sneakerDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        sneakerService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
