package com.api.foodburg.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.api.foodburg.models.Cupom;

@Repository
public interface CupomRepository extends CrudRepository<Cupom, UUID> {
    
    public List<Cupom> findAll();
}
