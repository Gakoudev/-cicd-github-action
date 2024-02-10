package com.gakoudev.cicd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gakoudev.cicd.dto.ProduitDto;
import com.gakoudev.cicd.services.ProduitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WebMvcTest(ProduitController.class)
class ProduitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProduitService produitService;

    @InjectMocks
    private ProduitController produitController;

    @Test
    void getAllProduits() throws Exception {
        List<ProduitDto> produits = new ArrayList<>();
        ProduitDto produit1 = new ProduitDto();
        produit1.setId(1L);
        produit1.setLibelle("Téléphone");
        produits.add(produit1);

        when(produitService.getAllProduits()).thenReturn(produits);

        mockMvc.perform(MockMvcRequestBuilders.get("/produits")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].libelle").value("Téléphone"));
    }

    @Test
    void addProduit() throws Exception {
        ProduitDto produitDto = ProduitDto.builder()
                .libelle("Ordinateur")
                .codeProduit("ORD123")
                .qtStock(20)
                .prix(250000)
                .build();

        ProduitDto savedProduitDto = ProduitDto.builder()
                .id(1L)
                .libelle("Ordinateur")
                .codeProduit("ORD123")
                .qtStock(20)
                .prix(250000)
                .build();

        when(produitService.saveProduit(produitDto)).thenReturn(savedProduitDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/produits")
                        .content(asJsonString(produitDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.libelle").value("Ordinateur"));
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
