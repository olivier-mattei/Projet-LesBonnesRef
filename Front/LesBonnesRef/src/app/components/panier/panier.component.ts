import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {

  constructor(private http: HttpClient,private serviceProduit:ProduitService) { }

  tableauArticle:any=this.serviceProduit.panier;
  tableaucorrespondance=
  {
    id: 0,
    idProduit:0,
  }

  ngOnInit(): void 
  {
    this.affichageblabla();
  }

  affichageblabla()
  {
    console.log("affichage à l'actiualisation de la page")
    console.log(this.tableauArticle);
  }

  suppressionProduit(indexProduit:any)
  {
    console.log("test 2 index recup " + indexProduit);
    // fonctionne avec index et non id qui est une colonne contenant mes id produits
    //exemple index=0 et id=3
    var test=this.tableauArticle.splice(indexProduit,1);// supprime l'élément du tableau local par sont id
    this.serviceProduit.panier=this.tableauArticle;//met à jour la table 
    this.affichageblabla();
  }

  actualisationProduit(index:any)
  {
    console.log("test 1 id produit");

    //récupération de mon valeur quantité
    let quantite = (<HTMLInputElement>document.getElementById("quantiteChange")).value;
    console.log("quantité récupéré:"+quantite);
    this.tableauArticle[index].quantiteDemande=quantite; //enregistrement de ma quantité dans le tableau
    console.log("quantité enregistré dans le tableau"+this.tableauArticle[index].quantiteDemande)


    console.log("test 2 ajout ");
    this.tableauArticle[index].prixTotal=this.tableauArticle[index].prix*this.tableauArticle[index].quantiteDemande; //prix du produit * quantité demandé
    console.log("prix totale"+this.tableauArticle[index].prixTotal);
    
    console.clear();
    console.log("affichage aprés modif du produit");
    console.log(this.tableauArticle);
    this.serviceProduit.panier=this.tableauArticle;//met à jour la table 
    this.affichageblabla();
  }

}
