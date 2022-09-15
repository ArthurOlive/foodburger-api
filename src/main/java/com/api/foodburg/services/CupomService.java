package com.api.foodburg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.api.foodburg.models.Cupom;
import com.api.foodburg.repositories.CupomRepository;

@Service
public class CupomService {
    
    @Autowired
    private CupomRepository cupomRepository;

    public List<Cupom> getAll() {
        return cupomRepository.findAll();
    }

}
