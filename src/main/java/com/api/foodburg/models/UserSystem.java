package com.api.foodburg.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserSystem implements Serializable {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Auth auth;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Profile profile;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Auth getAuth() {
        return auth;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Profile getProfile() {
        return profile;
    }
    
    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
