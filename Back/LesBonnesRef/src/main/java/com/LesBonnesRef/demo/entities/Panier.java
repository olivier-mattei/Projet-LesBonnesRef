package com.LesBonnesRef.demo.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Panier
{
	@Id //création de l'id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//incrementation de l'id
	private Long id;
	
	//clé étrangère
	@ManyToMany(mappedBy = "panier")
	private List<Produit> listePanier=new ArrayList<Produit>();

	//par défaut
	public Panier() 
	{
		super();
	}

	//avec paramètre
	public Panier(Long id, List<Produit> listePanier, Utilisateur acheteur) {
		super();
		this.id = id;
		this.listePanier = listePanier;
		this.acheteur = acheteur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produit> getListePanier() {
		return listePanier;
	}

	public void setListePanier(List<Produit> listePanier) {
		this.listePanier = listePanier;
	}

	public Utilisateur getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}

	@ManyToOne //création de ma clé étrangère
	private Utilisateur acheteur;
}
