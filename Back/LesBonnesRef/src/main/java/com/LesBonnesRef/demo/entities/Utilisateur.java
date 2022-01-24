package com.LesBonnesRef.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur 
{
	@Id //création de l'id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//incrementation de l'id
	private Long id;

	@Column(length=10)
	private String nom,prenom; //taille de charactére 10 max

	@Column(length=13) //taille de charactére 13 max
	private String telephone,motDePasse;

	@Column(length=25) //taille de charactére 25 max
	private String mail,adresse; //création de mon utilisateur

	@Column(length=1)//taille de charactére 1
	private int NoteVendeur; //note total sur 5

	//constructeur par défault
	public Utilisateur()
	{
		
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
		NoteVendeur = noteVendeur; 
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


	public int getNoteVendeur() 
	{
		return NoteVendeur;
	}


	public void setNoteVendeur(int noteVendeur) 
	{
		NoteVendeur = noteVendeur;
	}





}
