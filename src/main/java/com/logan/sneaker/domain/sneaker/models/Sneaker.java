package com.logan.sneaker.domain.sneaker.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // JPA to save to the database
@NoArgsConstructor // Non argument constructor
@RequiredArgsConstructor // parameterized constructor
@Data // getters and setters
public class Sneaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String street;

    @NonNull
    private String city;

    @NonNull
    private String state;

    @NonNull
    private long zip;

    @NonNull
    private SneakerType sneakerType;

    public String toString(){
        return String.format("%d %s %s %s", id, firstName,lastName,email,street,city,state,zip, sneakerType);
    }
}
