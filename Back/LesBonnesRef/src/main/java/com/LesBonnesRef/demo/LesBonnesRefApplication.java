package com.LesBonnesRef.demo;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

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
		
		//chemin de mon ordi 
//        String path = "D:/Système/Users/CHERUB96X/Images/projetImage";
//		
//		//création de mes images
//		BufferedImage img1 = ImageIO.read(new File(path+"/image1.jpg"));
//		
//		BufferedImage img2 = ImageIO.read(new File(path+"/image2.jpg"));
//		
//		BufferedImage img3 = ImageIO.read(new File(path+"image3.jpg"));
//		
//		//création de mon tableau d'image
//		BufferedImage tableauImgProduit[] = new BufferedImage[3];
//		
//		//ajout des images dans le tableau
//		tableauImgProduit[0]=img1;
//		tableauImgProduit[1]=img2;
//		tableauImgProduit[2]=img3;
//		
		
		//création de l'utilisateur 
		Utilisateur user1 = new Utilisateur(null,"Prie","Galaad","067578843","TikitaJeLaLove","PrieGalaad@gmail.com","4 Rue De la BheuRisière","vendeur",4);
		utilisateurRepository.save(user1);
		
		Utilisateur user2= new Utilisateur(null,"Mattei","Olivier","067578843","titi13","olimatt96@gmail.com","4 Rue De la Concorde","admin",5);
		utilisateurRepository.save(user2);
		
		//création d'un produits
//		Produit produit1 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1,tableauImgProduit);
//		produitRepository.save(produit1);
		
		Produit produit2 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit2);
		
		Produit produit3 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit3);
		
		Produit produit4 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit4);
		
		Produit produit5 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit5);
		
		Produit produit6 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit6);
		
		Produit produit7= new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit7);
		
		Produit produit8 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit8);
		
		Produit produit9 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit9);
		
		Produit produit10 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit10);
		
		Produit produit11 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit11);
		
		Produit produit12 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit12);
		
		Produit produit13 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit13);
		
		Produit produit14 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit14);
		
		Produit produit15 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit15);
		
		Produit produit16 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit16);
		
		Produit produit17= new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1);
		produitRepository.save(produit17);
		
		
		
		
		restRespository.exposeIdsFor(Produit.class); //permet la récupération du champ id
		
	}

}
