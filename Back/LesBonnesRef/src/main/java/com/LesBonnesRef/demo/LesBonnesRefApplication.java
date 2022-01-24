package com.LesBonnesRef.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//inmport des interface de mes composants
import com.LesBonnesRef.demo.dao.ProduitRepository;
import com.LesBonnesRef.demo.dao.UtilisateurRepository;

//import des entités 
import com.LesBonnesRef.demo.entities.Utilisateur;
import com.LesBonnesRef.demo.entities.Produit;

@SpringBootApplication
public class LesBonnesRefApplication implements CommandLineRunner
{
	@Autowired //permet de récupérer les données produit
	private ProduitRepository produitRepository;
	
	@Autowired //permet de récupérer les données utilisateur
	private UtilisateurRepository utilisateurRepository;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(LesBonnesRefApplication.class, args);// lancement de la méthode run
	}

	@Override
	public void run(String... args) throws Exception 
	{
		// TODO Auto-generated method stub
		//création de l'utilisateur 
		Utilisateur user1 = new Utilisateur(null,"Prie","Galaad","067578843","TikitaJeLaLove","PrieGalaad@gmail.com","4 Rue De la BheuRisière",4);
		System.out.println("Tengo Vida el backoLongo");
		
		//création d'un produits
		
	}

}
