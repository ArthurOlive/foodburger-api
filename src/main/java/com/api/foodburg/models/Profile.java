package com.api.foodburg.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Profile implements Serializable {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;
    private String name;
    private LocalDate birth;
    private String document;
    //private GenderEnum gender;
    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private Address address;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Profile() {
    }

    public Profile(String name, LocalDate birth, String document) {
        this.name = name;
        this.birth = birth;
        this.document = document;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}