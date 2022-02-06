import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  url = "http://localhost:8082/utilisateurs";

  public UserArray:any = new Array();//création de mon tableau de stockage

  constructor(private http: HttpClient) { }

  ajoutUtilisateur(utilisateur: any) //méthode création d'utilisateur
  { 
    return this.http.post(this.url, utilisateur);
  }

  recuperationUtilisateurParUrlProduit(urlProduit:any) //méthode obtention de l'utilisateur du produit sélectionné 
  {
    return this.http.get(urlProduit);
  }

  recuperationDeToutLesUtilisateurs() //méthode récupération de tous les utilisateurs
  {
    this.http.get(this.url).subscribe(dataUsers => 
    {
      this.UserArray=dataUsers;
      // console.log("mon tableau utilisateur:")
      // console.log(this.UserArray);
    });

  }




}
