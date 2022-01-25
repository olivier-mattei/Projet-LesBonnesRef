package com.LesBonnesRef.demo.entities;

import java.util.Collection;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur 
{
	@Id //création de l'id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//incrementation de l'id
	private Long id;

	@Column(length=10)
	private String nom,prenom; //taille de charactére 10 max

	@Column(length=13) //taille de charactére 13 max
	private String telephone;

	@Column(length=15) //taille de charactére 15 max
	private String motDePasse;
	
	@Column(length=25) //taille de charactére 25 max
	private String mail,adresse; //création de mon utilisateur

	@Column(length=1)//taille de charactére 1
	private int noteVendeur; //note total sur 5

	@Column
	private int portefeuille;
	
	@OneToMany(mappedBy= "utilisateur")//j'ai ma clé étrangère stocké dans produits
	private Collection <Produit> tableauDesProduits; //stockage de tout les produits pour l'utilisateur
	
	//constructeur par défault
	public Utilisateur()
	{
		super();
		this.portefeuille= this.GenerationRandomArgent(); //appelle de ma méthode Random pour l'argent
	}
	
	//constructeur avec paramètre
	public Utilisateur(Long id, String nom, String prenom, String telephone, String motDePasse, String mail,String adresse, int noteVendeur) 
	{
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.motDePasse = motDePasse;
		this.mail = mail;
		this.adresse = adresse;
		this.noteVendeur = noteVendeur;
		this.portefeuille= this.GenerationRandomArgent(); //appelle de ma méthode Random pour l'argent
	}

	//Getters and Setters
	public Long getId() 
	{
		return id;
	}


	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNom() 
	{
		return nom;
	}


	public void setNom(String nom) 
	{
		this.nom = nom;
	}

	public String getPrenom() 
	{
		return prenom;
	}

	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}

	public String getTelephone() 
	{
		return telephone;
	}

	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}

	public String getMotDePasse() 
	{
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) 
	{
		this.motDePasse = motDePasse;
	}

	public String getMail() 
	{
		return mail;
	}

	public void setMail(String mail) 
	{
		this.mail = mail;
	}

	public String getAdresse() 
	{
		return adresse;
	}

	public void setAdresse(String adresse)
	{
		this.adresse = adresse;
	}
	
	public int getNoteVendeur() {
		return noteVendeur;
	}

	public void setNoteVendeur(int noteVendeur) {
		this.noteVendeur = noteVendeur;
	}

	public int getPortefeuille() {
		return portefeuille;
	}

	public void setPortefeuille(int portefeuille) {
		this.portefeuille = portefeuille;
	}

	public Collection<Produit> getTableauDesProduits() {
		return tableauDesProduits;
	}

	public void setTableauDesProduits(Collection<Produit> tableauDesProduits) {
		this.tableauDesProduits = tableauDesProduits;
	}

	//fonction générer lors de la création de notre utilisateur
	public int GenerationRandomArgent()
	{
		//System.out.println("test Generation Random Argent");
		Random rand = new Random();
		int randomNumber=rand.nextInt(1000 - 500 + 1) + 500;// génération de mon random
		return randomNumber;
	}


}
