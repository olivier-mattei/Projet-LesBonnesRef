package com.LesBonnesRef.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.LesBonnesRef.demo.entities.Produit;

@CrossOrigin("http://localhost:4200") //j'autorise l'accès à mon front-end

@RestController
public interface ProduitRepository extends JpaRepository<Produit, Long>
{
	@RestResource(path="/nomProduits")
	public List<Produit> findBynomProduitsContains(@Param("nomProduits") String nomProduits);
	
	@RestResource(path="/categorie")
    public List<Produit> findBycategorieContains(@Param("categorie") String categorie);
}
