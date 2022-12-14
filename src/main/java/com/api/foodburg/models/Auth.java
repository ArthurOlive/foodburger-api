package com.api.foodburg.models;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Auth implements Serializable {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Column(unique = true)
    private String username;

    private String password;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Auth() {
    }

    public Auth(String username) {
        this.username = username;
    }

    public Auth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getUsername() {
        return username;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @JsonIgnoreProperties
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsename(String username) {
        this.username = username;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
}
