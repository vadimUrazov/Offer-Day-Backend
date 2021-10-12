package com.example.offerdaysongs.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;

    public Company() {
    }

    public Company(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Company(String name) {
        this(0, name);
    }
}
