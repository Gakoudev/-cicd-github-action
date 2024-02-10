package com.gakoudev.cicd.services;

import com.gakoudev.cicd.dao.ProduitDao;
import com.gakoudev.cicd.dto.ProduitDto;
import com.gakoudev.cicd.entities.Produit;
import com.gakoudev.cicd.mapper.ProduitMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class ProduitServiceTest {
/*
    @InjectMocks
    private ProduitService produitService;

    @Mock
    private ProduitDao produitDao;

    @Mock
    private ProduitMapper produitMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateProduit() {
        Long id = 1L;
        ProduitDto produitDto = new ProduitDto();
        Produit produit = new Produit();
        when(produitMapper.toEntity(produitDto)).thenReturn(produit);
        when(produitDao.updateProduit(id, produit)).thenReturn(produit);
        when(produitMapper.toDto(produit)).thenReturn(produitDto);

        ProduitDto updatedProduitDto = produitService.updateProduit(id, produitDto);

        assertEquals(produitDto, updatedProduitDto);
        verify(produitDao, times(1)).updateProduit(id, produit);
    }

    @Test
    public void testDeleteProduit() {
        Long id = 1L;
        produitService.deleteProduit(id);

        verify(produitDao, times(1)).deleteProduit(id);
    }

    @Test
    public void testGetProduitById() {
        Long id = 1L;
        Produit produit = new Produit();
        ProduitDto produitDto = new ProduitDto();
        when(produitDao.getProduitById(id)).thenReturn(produit);
        when(produitMapper.toDto(produit)).thenReturn(produitDto);

        ProduitDto fetchedProduitDto = produitService.getProduitById(id);

        assertEquals(produitDto, fetchedProduitDto);
    }
    
 */
}
