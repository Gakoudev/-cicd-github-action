package com.gakoudev.cicd.services;


import com.gakoudev.cicd.dao.ProduitDao;
import com.gakoudev.cicd.dto.ProduitDto;
import com.gakoudev.cicd.entities.Produit;
import com.gakoudev.cicd.mapper.ProduitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitService {
    @Autowired
    private ProduitDao produitDao;

    @Autowired
    private ProduitMapper produitMapper;

    public ProduitDto saveProduit(ProduitDto produitDto) {
        Produit produit = produitDao.saveProduit(produitMapper.toEntity(produitDto));
        return produitMapper.toDto(produit);
    }

    public List<ProduitDto> getAllProduits() {
        List<Produit> produits = produitDao.getAllProduits();
        return produits.stream().map(produitMapper::toDto).collect(Collectors.toList());
    }

    public ProduitDto getProduitById(Long id) {
        Produit produit = produitDao.getProduitById(id);
        return produit != null ? produitMapper.toDto(produit) : null;
    }

    public ProduitDto updateProduit(Long id, ProduitDto produitDto) {
        Produit produit = produitDao.updateProduit(id, produitMapper.toEntity(produitDto));
        return produit != null ? produitMapper.toDto(produit) : null;
    }

    public void deleteProduit(Long id) {
        produitDao.deleteProduit(id);
    }
}
