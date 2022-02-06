import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  //création de mon tableau panier
  panier = new Array();

  url = "http://localhost:8082/produits";

  constructor(private http: HttpClient) { }

  afficherProduit() //méthode pour l'affichage des produits
  {
    return this.http.get(this.url);
  }

  ajoutProduit(produit: any) //méthode création de produit
  {
    return this.http.post(this.url, produit);
  }

  modifProduit(modifProduit: any) //méthode modification de produit
  {
    return this.http.put(this.url + "/" + modifProduit.id, modifProduit);
  }

  supprimerProduit(id: any) //méthode suppression de produit
  {
    return this.http.delete(this.url + "/" + id);
  }

  rechercherProduit(motCle: any) { //méthode rechercher produit par nom
    return this.http.get(this.url + "/search/nomProduits?nomProduits=" + motCle);
  }

  rechercheParCategorie(categorie: any) { //méthode rechercher produits par catégorie
    return this.http.get(this.url + "/search/categorie?categorie=" + categorie);
  }

  paginationProduit(page: number, size: number) {
    return this.http.get(this.url + "?page=" + page + "&size=" + size);
  }

  ajoutCommandePanier(produit:any)
  {
    return this.http.post("http://localhost:8082/utilisateurs/"+2+"/panier", produit);
  }

}
