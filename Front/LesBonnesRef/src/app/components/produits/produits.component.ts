import { Component, OnInit } from '@angular/core';
import {ProduitService} from 'src/app/services/produit.service';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {

  listeDesProduits:any
  constructor(private produitService:ProduitService) { }

  produitsModifie=
  {
    id:0,
    nomProduits:"",
    detaille:"",
    prix:"",
    categorie:"",
    marque:"",
    imageProduit:"",
    quantite:"",
  }

  ngOnInit(): void 
  {
    this.affichageProduit();
  }

  //méthode GET affiche tout le contenu de la bdd
  affichageProduit()
  {
    this.produitService.afficherProduit().subscribe(data=>
      {
        this.listeDesProduits =data;
        console.log(this.listeDesProduits);
      })
  }

  //méthode POST ajout dans la bdd
  creationProduit(nouveauProduit:any)
  {
    var valueProduits= nouveauProduit.value;
    this.produitService.ajoutProduit(valueProduits).subscribe(Response=>
    {
      console.log("création de l'objet réussi");
      this.affichageProduit;//réactualisation de la page
    })
  }

  //méthode PUT envoie de mon objet modifié à la bdd
  modificationProduit()
  {
    this.produitService.modifProduit(this.produitsModifie).subscribe(data=>
    {
      console.log("objet modifié");
    })
  }

  //méthode DELETE suppression d'un élément de la bdd
  suppressionProduits(produitId:any)
  {
    this.produitService.supprimerProduit(produitId).subscribe(data=>
    {
      console.log("produit supprimmé");
    })
    this.affichageProduit();//réactualisation de la page
  }


}
