package com.api.foodburg.controlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.foodburg.models.Cupom;
import com.api.foodburg.services.CupomService;


@RestController
public class CupomController {

    @Autowired
    private CupomService cupomService;
    
    @GetMapping("/cupons-2")
    public List<Cupom> getCupons() {

        List<Cupom> list = cupomService.getAll();

        return list;
    }

}
