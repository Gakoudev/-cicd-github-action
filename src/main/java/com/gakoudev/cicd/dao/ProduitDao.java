package com.gakoudev.cicd.dao;

import com.gakoudev.cicd.entities.Produit;
import com.gakoudev.cicd.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProduitDao {
    @Autowired
    private ProduitRepository produitRepository;

    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(Long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        return optionalProduit.orElse(null);
    }

    public Produit updateProduit(Long id, Produit newProduit) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isPresent()) {
            Produit existingProduit = optionalProduit.get();
            existingProduit.setLibelle(newProduit.getLibelle());
            existingProduit.setQtStock(newProduit.getQtStock());
            existingProduit.setPrix(newProduit.getPrix());
            return produitRepository.save(existingProduit);
        }
        return null;
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
