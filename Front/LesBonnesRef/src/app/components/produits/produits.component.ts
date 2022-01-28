import { Component, OnInit } from '@angular/core';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {

  listeDesProduits: any
  constructor(private produitService: ProduitService) { }

  produitTrouve: any;
  motCle: any;

  produitsModifie =
    {
      id: 0,
      nomProduits: "",
      detaille: "",
      prix: "",
      categorie: "",
      marque: "",
      imageProduit: "",
      quantite: "",
    }

  compteurLigne: number = 0;

  ngOnInit(): void {
    this.affichageProduit();
  }

  couleurCardProduit(idCard: number) {
    ////////////////////////////déclaration de mon tableau et de ma variable local////////////////////////////////////////
    let TableauCouleur = ["#3ED598", "#F2B200", "#FF565E", "#69A1BA"];// Vert,Jaune,Rouge,Bleu
    //console.log("méthode CouleurCardPrecedente");
    let IndexCouleurCardActuelle = 0;
    let test = 0;
    //////////////////////////////////////////////Condition afin de pas prendre la même couleur que celle utilisé juste avant////////////////////////////////////////////
    if (idCard == 1)//au début
    {
      IndexCouleurCardActuelle = 0;//vert
      test = 1
    }

    else if (idCard % 4 == 0)//test module de 4
    {
      IndexCouleurCardActuelle = 3;//bleu
      test = 2;
    }

    else if (idCard % 2 == 0)//si module de 3
    {
      IndexCouleurCardActuelle = 1;//Jaune
      test = 3;
    }

    else if (idCard % 3 == 0)//si module de 3
    {
      IndexCouleurCardActuelle = 2;//Rouge
      test = 4;
    }

    else //reste
    {
      IndexCouleurCardActuelle = 0;//Vert
      test = 5;
    }

    console.log(test + " pour id " + idCard);

    return TableauCouleur[IndexCouleurCardActuelle];
    //////////////////////////////////////////////fin Condition////////////////////////////////////////////
  }

  //méthode GET affiche tout le contenu de la bdd
  affichageProduit() {
    this.produitService.afficherProduit().subscribe(data => {
      this.listeDesProduits = data;
      console.log(this.listeDesProduits);
    })
  }

  //méthode POST ajout dans la bdd
  creationProduit(nouveauProduit: any) {
    var valueProduits = nouveauProduit.value;
    this.produitService.ajoutProduit(valueProduits).subscribe(Response => {
      console.log("création de l'objet réussi");
      this.affichageProduit;//réactualisation de la page
    })
  }

  //méthode PUT envoie de mon objet modifié à la bdd
  modificationProduit() {
    this.produitService.modifProduit(this.produitsModifie).subscribe(data => {
      console.log("objet modifié");
    })
  }

  //méthode DELETE suppression d'un élément de la bdd
  suppressionProduits(produitId: any) {
    this.produitService.supprimerProduit(produitId).subscribe(data => {
      console.log("produit supprimmé");
    })
    this.affichageProduit();//réactualisation de la page
  }

  //méthode GET recherche par mot clé avec two way binding
  rechercheMotCle() {
    this.produitService.rechercherProduit(this.motCle).subscribe(data => {
      this.listeDesProduits = data;
      this.produitTrouve = this.listeDesProduits._embedded.produits.length;
    })

  }


}
