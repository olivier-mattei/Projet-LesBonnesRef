package com.LesBonnesRef.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.LesBonnesRef.demo.entities.Panier;
import com.LesBonnesRef.demo.entities.Utilisateur;

@CrossOrigin("http://localhost:4200") //j'autorise l'accès à mon front-end

@RestController

public interface PanierRepository extends JpaRepository<Panier,Long> 
{
	
}
