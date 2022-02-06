package com.LesBonnesRef.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LesBonnesRef.demo.entities.Panier;
import com.LesBonnesRef.demo.entities.Produit;
import com.LesBonnesRef.demo.entities.Utilisateur;

import com.LesBonnesRef.demo.dao.UtilisateurRepository;

@RestController
public class ControllerPanier 
{
	@Autowired
	private UtilisateurRepository userResp;
	
	//ajout d'un produit dans le panier par l'id utilisateur
	@RequestMapping(value="utilisateurs/{idUtilisateur}/panier",method = RequestMethod.POST)
	public String ajoutDansPanier(@PathVariable ("idUtilisateur") Long idUtilisateur, @RequestBody List<Produit> produit)
	{
		Utilisateur utilisateurSelect= new Utilisateur();
		utilisateurSelect = userResp.findById(idUtilisateur).orElse(null); //récupération de mon utilisateur
		Panier panierSelect =new Panier(null,produit,utilisateurSelect);
		
		String reussi ="Enregistrement terminé";
		return reussi;
	}
}

