package com.LesBonnesRef.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.LesBonnesRef.demo.entities.Produit;

@RestController
public interface ProduitRepository extends JpaRepository<Produit, Long>
{

}
