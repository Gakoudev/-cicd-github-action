package com.gakoudev.cicd.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProduitDto {
    private Long id;
    private String libelle;
    private String codeProduit;
    private int qtStock;
    private float prix;
}
