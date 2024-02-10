package com.gakoudev.cicd.dao;

import com.gakoudev.cicd.entities.Produit;
import com.gakoudev.cicd.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProduitDaoTest {

    @Mock
    private ProduitRepository produitRepository;

    @InjectMocks
    private ProduitDao produitDao;

    @Test
    void saveProduit() {
        Produit produit = Produit.builder()
                .libelle("Téléphone")
                .codeProduit("PHN123")
                .qtStock(50)
                .prix(150000)
                .build();

        Produit savedProduit = Produit.builder()
                .id(1L)
                .libelle("Téléphone")
                .codeProduit("PHN123")
                .qtStock(50)
                .prix(150000)
                .build();

        when(produitRepository.save(produit)).thenReturn(savedProduit);

        Produit returnedProduit = produitDao.saveProduit(produit);

        assertNotNull(returnedProduit);
        assertEquals(savedProduit.getId(), returnedProduit.getId());
        assertEquals(savedProduit.getLibelle(), returnedProduit.getLibelle());
        assertEquals(savedProduit.getQtStock(), returnedProduit.getQtStock());
        assertEquals(savedProduit.getPrix(), returnedProduit.getPrix());

        verify(produitRepository, times(1)).save(produit);
    }

    @Test
    void getAllProduits() {
        List<Produit> produits = new ArrayList<>();
        produits.add(new Produit());
        produits.add(new Produit());
        when(produitRepository.findAll()).thenReturn(produits);

        List<Produit> retrievedProduits = produitDao.getAllProduits();

        assertNotNull(retrievedProduits);
        assertEquals(produits.size(), retrievedProduits.size());
        verify(produitRepository, times(1)).findAll();
    }

    @Test
    void getProduitById() {
        Long id = 1L;
        Produit produit = new Produit();
        when(produitRepository.findById(id)).thenReturn(Optional.of(produit));

        Produit retrievedProduit = produitDao.getProduitById(id);

        assertNotNull(retrievedProduit);
        assertEquals(produit, retrievedProduit);
        verify(produitRepository, times(1)).findById(id);
    }

    @Test
    void updateProduit() {
        Long id = 1L;
        Produit existingProduit = new Produit();
        existingProduit.setId(id);
        Produit newProduit = new Produit();
        newProduit.setId(id);

        when(produitRepository.findById(id)).thenReturn(Optional.of(existingProduit));
        when(produitRepository.save(existingProduit)).thenReturn(existingProduit);

        Produit updatedProduit = produitDao.updateProduit(id, newProduit);

        assertNotNull(updatedProduit);
        assertEquals(existingProduit, updatedProduit);
        verify(produitRepository, times(1)).findById(id);
        verify(produitRepository, times(1)).save(existingProduit);
    }

    @Test
    void deleteProduit() {
        Long id = 1L;
        produitDao.deleteProduit(id);
        verify(produitRepository, times(1)).deleteById(id);
    }
}
