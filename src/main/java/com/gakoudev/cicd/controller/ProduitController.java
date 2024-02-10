package com.gakoudev.cicd.controller;

import com.gakoudev.cicd.dto.ProduitDto;
import com.gakoudev.cicd.mapper.ProduitMapper;
import com.gakoudev.cicd.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @Autowired
    private ProduitMapper produitMapper;

    @PostMapping
    public ProduitDto addProduit(@RequestBody ProduitDto produitDto) {
        ProduitDto produit = produitService.saveProduit(produitDto);
        return produit;
    }

    @GetMapping
    public List<ProduitDto> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public ProduitDto getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }

    @PutMapping("/{id}")
    public ProduitDto updateProduit(@PathVariable Long id, @RequestBody ProduitDto produitDto) {
        return produitService.updateProduit(id, produitDto);
    }
    /*
    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
    }
    */

}
