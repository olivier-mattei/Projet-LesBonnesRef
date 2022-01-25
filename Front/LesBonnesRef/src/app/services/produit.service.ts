import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  url = "http://localhost:8082/produits";

  constructor(private http: HttpClient) { }

  afficherProduit() {  //méthode pour l'affichage des produits
    return this.http.get(this.url);
  }

  ajoutProduit(produit: any) { //méthode creation de produit
    return this.http.post(this.url, produit);
  }

  modifProduit(modifProduit: any) { //méthode modification de produit
    return this.http.put(this.url + "/" + modifProduit.id, modifProduit);
  }

  suprimerProduit(id: any) { //méthode supression de produit
    return this.http.delete(this.url + "/" + id);
  }
  
}
