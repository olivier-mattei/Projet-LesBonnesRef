package com.LesBonnesRef.demo;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

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
	
	@Autowired
	private RepositoryRestConfiguration restRespository; //connection à l'API rest
	
	public static void main(String[] args) 
	{
		SpringApplication.run(LesBonnesRefApplication.class, args);// lancement de la méthode run
	}

	@Override
	public void run(String... args) throws Exception 
	{
		// TODO Auto-generated method stub
		System.out.println("Tengo Vida el backoLongo");
		
		//création de l'utilisateur 
		Utilisateur user1 = new Utilisateur(null,"Prie","Galaad","067578843","TikitaJeLaLove","PrieGalaad@gmail.com","4 Rue De la BheuRisière",4);
		utilisateurRepository.save(user1);
		
		//création d'un produits
		Produit produit1 = new Produit(null,"produit test","dfdfddffdsfdfdfdffdfddffdfdf","150","test","MarquageTest","blabla/url",455, user1);
		produitRepository.save(produit1);
		
		restRespository.exposeIdsFor(Produit.class); //permet la récupération du champ id
		
	}

}
