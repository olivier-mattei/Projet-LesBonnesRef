import { Component, OnInit } from '@angular/core';
import { ProduitService } from 'src/app/services/produit.service';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {

  listeDesProduits: any;

  // pagination
  nombreTotalPages: any;

  // pour la recherche
  produitTrouve: any;
  motCle: any;

  //pour la couleur des card
  compteurLigne: number = 0;

  //test si connecter
  pasConnecte:boolean=true;

  //pour l'affichage en detail dans le panel produit
  NomPrenomVendeur: string = "";
  hrefUtilisateur: any;

  //affichage du prix total selon quantité du produit sélectionné
  quantiteAchat:number=0;
  prixTotalProduit:number=0;

  constructor(private produitService: ProduitService, private utilisateurService: UtilisateurService) { }

  //objet produit
  produitsModifie =
  {
      id: 0,
      nomProduits: "",
      detaille: "",
      prix: 0,
      categorie: "",
      marque: "",
      imageProduit: String, //création de mon objet de type image
      quantite: 0,
      quantiteDemande:0,
      prixTotal:0,
  }
  
  //objet utilisateur
  utilisateurVendeur: any =
    {
      nom: "",
      prenom: "",
      telephone: "",
      adresse: "",
      mail: "",
      motDePasse: "",
      noteVendeur: 0,
      portefeuille: 0,
    }

  //tableau par catégorie
  categorie:string[] = ['Jardinage', 'Domestique','JeuxVideo','Livres','Vetement','Electronique','Musique','Sport'];

  ngOnInit(): void {
    this.affichageProduit();
    this.utilisateurService.recuperationDeToutLesUtilisateurs()//récupération de tous les utilisateurs partie service
    this.testConnecter()//test de connection utilisateur pour affichage détail produit
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

    //console.log(test+" pour id "+idCard);
    return TableauCouleur[IndexCouleurCardActuelle];
    //////////////////////////////////////////////fin Condition////////////////////////////////////////////
  }

  //méthode GET affiche tout le contenu de la bdd
  affichageProduit() {
    // this.produitService.afficherProduit().subscribe(data => {
    this.produitService.paginationProduit(0).subscribe(data => {
      this.listeDesProduits = data;
      console.log(this.listeDesProduits);
    })
  }

  //méthode POST ajout dans la bdd
  creationProduit(nouveauProduit: any) {
    var valueProduits = nouveauProduit.value;
    this.produitService.ajoutProduit(valueProduits).subscribe(Response => {
      console.log("création de l'objet réussi");
      this.affichageProduit();//réactualisation de la page
    })
  }

  //méthode PUT envoie de mon objet modifié à la bdd
  modificationProduit() {
    this.produitService.modifProduit(this.produitsModifie).subscribe(data => {
      console.log("objet modifié");
      this.affichageProduit();//réactualisation de la page
    })
  }

  //méthode DELETE suppression d'un élément de la bdd
  suppressionProduits(produitId: any) {
    this.produitService.supprimerProduit(produitId).subscribe(data => {
      console.log("produit supprimmé");
    })
    this.affichageProduit();//réactualisation de la page
  }

  recuperationDesData(dataProduit: any) {
    //récupération des data du produit
    this.produitsModifie = dataProduit;//enregistrement des data produit dans une variable locale

    console.clear()
    console.log(this.produitsModifie)
    //récupération de l'url utilisateur du produit
    this.hrefUtilisateur = dataProduit._links.vendeur.href

    //requêtes GET pour récupération des data vendeur
    this.utilisateurService.recuperationUtilisateurParUrlProduit(this.hrefUtilisateur).subscribe(dataVendeur => {
      this.utilisateurVendeur = dataVendeur;//enregistrement des data vendeur dans une variable locale
      this.NomPrenomVendeur = this.utilisateurVendeur.nom + " " + this.utilisateurVendeur.prenom;// concaténation pour récupération du nom + prenom
      console.log("nom utilisateur");
      console.log(this.NomPrenomVendeur);
    })
  }

  
  rechercheParCategorie(nbrCategorie:any)
  {
    let categorieChoisie =this.categorie[nbrCategorie];
    console.log("catégorie choisie "+categorieChoisie)
    this.produitService.rechercheParCategorie(categorieChoisie).subscribe(resultatRecherche => 
    {
      this.listeDesProduits = resultatRecherche; //stockage des data récupéré
      console.log("success");

    })
  }

  //méthode GET recherche par mot clé avec two way binding
  rechercheMotCle() {
    this.produitService.rechercherProduit(this.motCle).subscribe(data => {
      this.listeDesProduits = data;
      this.produitTrouve = this.listeDesProduits._embedded.produits.length;
    })
  }

  deuxiemePage() {
    this.produitService.paginationProduit(1).subscribe(data =>{
      this.listeDesProduits=data;
    })
  }

  testConnecter()
  {
    ///récupération des Stockage de Session///
    let objectSesion=JSON.parse(sessionStorage.getItem("object")||'{}')
    let role= objectSesion.role;
    let mail =objectSesion.mail;

    //si connecter 
    if(mail!=null&&role!=null){this.pasConnecte=false;}
  }

  // affichagePages() {
  //   this.produitService.paginationProduit(this.nombreTotalPages).subscribe(data => {
  //     this.listeDesProduits = data;
  //     this.nombreTotalPages = this.listeDesProduits.page.totalPages;
  //     console.log("nom de pages:" + this.nombreTotalPages);
  //   })
  // }

  //////////////////////////////////////// les fonctions pour le panier///////////////////////////////////////////
  
  //calcul du prix selon la quantité sélectionner
  calculPrixTotalParProduit()//calcul le prix totale selon la quantité choisie pour affichage coté HTML
  {
    this.prixTotalProduit=this.quantiteAchat*this.produitsModifie.prix;
  }

  //ajoute dans ma bdd le produit sélectionner 
  ajouterProduitAuPanier()
  {
    this.produitsModifie.quantiteDemande=this.quantiteAchat;//sauvegarde de la quantité sélectionner
    this.produitsModifie.prixTotal=this.prixTotalProduit;//sauvegarde du prix selon la quantité

    //lecture du session storage
    let objectSesion=JSON.parse(sessionStorage.getItem("object")||'{}')
    console.log(objectSesion);

    //ajout dans le tableau
    this.produitService.panier.push(this.produitsModifie);
    //console.clear();
    console.log("tableau produit");
    console.log(this.produitService.panier);

    //envoie vers la BDD
    // this.produitService.ajoutPanier(this.produitsModifie).subscribe(Response => 
    // {
    //   console.log("j'ai réussi");
    //   //récupération de l'objet commandé et stockage dans la tableau
    // });
  }
}
