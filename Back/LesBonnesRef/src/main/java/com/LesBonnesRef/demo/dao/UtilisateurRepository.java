package com.LesBonnesRef.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.LesBonnesRef.demo.entities.Utilisateur;

//générations des données au format JSON
@RestController
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>
{
	
}
