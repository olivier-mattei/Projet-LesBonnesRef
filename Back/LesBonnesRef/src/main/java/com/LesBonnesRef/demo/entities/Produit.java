package com.LesBonnesRef.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/* import des Liste */
import java.awt.Image; // ma classe image
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Entity
public class Produit 
{

	@Id //création de l'id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//incrementation de l'id
	private Long id;

	@Column
	private String nomProduits,detaille,prix,categorie,marque,imageProduit;
	
	@Column
	private int quantite;

	//a regarder plus tard
	//private List<Image> myArrayList = new ArrayList<Image>(); //tableau d'image

	@ManyToOne
	private Utilisateur utilisateur;//création de ma clé étrengère
	
	//constructeur sans paramètre
	public Produit() 
	{
		super();
	}

	//constructeur avec paramètre
	public Produit(Long id, String nomProduits, String detaille, String prix, String categorie, String marque,String imageProduit, int quantite, Utilisateur utilisateur) 
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
		this.utilisateur = utilisateur;
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
}
