package com.gakoudev.cicd.mapper;
import com.gakoudev.cicd.dto.ProduitDto;
import com.gakoudev.cicd.entities.Produit;
import org.mapstruct.Mapper;
@Mapper
public interface ProduitMapper {
    ProduitDto toDto(Produit produit);
    Produit toEntity(ProduitDto produitDto);
}
