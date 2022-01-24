package com.LesBonnesRef.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* import des Liste */
import java.awt.Image; // ma classe image
import java.util.ArrayList;
import java.util.List;


@Entity
public class Produit 
{

	@Id //création de l'id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//incrementation de l'id
	private Long id;

	private String nomProduits,detaille,prix,categorie,marque,imageProduit;
	private int quantite;

	//a regarder plus tard
	//private List<Image> myArrayList = new ArrayList<Image>(); //tableau d'image

	//clé étrangère avec table Utilisateur
	private String adresseMail;
	private int noteVendeur;

	//constructeur sans paramètre
	public Produit() 
	{
		super();
	}

	//constructeur avec paramètre
	public Produit(Long id, String nomProduits, String detaille, String prix, String categorie, String marque,String imageProduit, int quantite, String adresseMail, int noteVendeur) 
	{
		super();
		this.id = id;
		this.nomProduits = nomProduits;
		this.detaille = detaille;
		this.prix = prix;
		this.categorie = categorie;
		this.marque = marque;
		this.imageProduit = imageProduit;
		this.quantite = quantite;
		this.adresseMail = adresseMail;
		this.noteVendeur = noteVendeur;
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

	public String getNomProduits() 
	{
		return nomProduits;
	}

	public void setNomProduits(String nomProduits) 
	{
		this.nomProduits = nomProduits;
	}

	public String getDetaille() 
	{
		return detaille;
	}

	public void setDetaille(String detaille) 
	{
		this.detaille = detaille;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) 
	{
		this.prix = prix;
	}

	public String getCategorie() 
	{
		return categorie;
	}

	public void setCategorie(String categorie) 
	{
		this.categorie = categorie;
	}

	public String getMarque() 
	{
		return marque;
	}

	public void setMarque(String marque) 
	{
		this.marque = marque;
	}

	public int getQuantite() 
	{
		return quantite;
	}

	public void setQuantite(int quantite)
	{
		this.quantite = quantite;
	}

	public String getImageProduit() 
	{
		return imageProduit;
	}

	public void setImageProduit(String imageProduit) 
	{
		this.imageProduit = imageProduit;
	}

	public String getAdresseMail() 
	{
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) 
	{
		this.adresseMail = adresseMail;
	}

	public int getNoteVendeur() 
	{
		return noteVendeur;
	}

	public void setNoteVendeur(int noteVendeur) 
	{
		this.noteVendeur = noteVendeur;
	}

}
