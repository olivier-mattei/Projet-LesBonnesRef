import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  url = "http://localhost:8082/utilisateurs";

  constructor(private http: HttpClient) { }

  ajoutUtilisateur(utilisateur: any) //méthode création d'utilisateur
  { 
    return this.http.post(this.url, utilisateur);
  }

  recuperationUtilisateurParUrlProduit(urlProduit:any)
  {
    return this.http.get(urlProduit);
  }


}
