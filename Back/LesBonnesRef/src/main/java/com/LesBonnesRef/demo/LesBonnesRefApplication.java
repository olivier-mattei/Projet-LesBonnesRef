package com.LesBonnesRef.demo;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

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
		System.out.println("El Backolongo tiene vida");
		
		//création de l'utilisateur 
		Utilisateur user1 = new Utilisateur(null,"Prie","Galaad","067578843","TikitaJeLaLove","PrieGalaad@gmail.com","4 Rue De la BheuRisière",4);
		utilisateurRepository.save(user1);
		
		//création d'un produits
		Produit produit1 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit1);
		
		restRespository.exposeIdsFor(Produit.class); //permet la récupération du champ id
		
	}

}
