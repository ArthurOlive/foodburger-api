package com.api.foodburg.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Cupom {
    
    // chave primaria
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;
    
    private String name;

    private BigDecimal percentage;

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getPercentage() {
        return percentage;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }
}
