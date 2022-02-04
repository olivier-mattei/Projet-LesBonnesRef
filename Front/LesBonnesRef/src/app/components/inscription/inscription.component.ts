import { Component, OnInit } from '@angular/core';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  constructor(private serviceUtilisateur: UtilisateurService) { }

  ngOnInit(): void {
    this.serviceUtilisateur.recuperationDeToutLesUtilisateurs();//récupération de tous les utilisateurs partie service
  }

  creationUtilisateur(utilisateur:any) 
  {
    let tableau=this.serviceUtilisateur.UserArray._embedded.utilisateurs;// mon tableau 
    //console.log(utilisateur.value);
    let donneesUtilisateur = utilisateur.value;
    donneesUtilisateur.role="vendeur"; //déclaration de mon role
    console.log(donneesUtilisateur);
    this.serviceUtilisateur.ajoutUtilisateur(donneesUtilisateur).subscribe(data =>
    {
      //réactualisation 
      this.serviceUtilisateur.recuperationDeToutLesUtilisateurs()//récupération de tous les utilisateurs partie service

      // Enregistrement des données dans sessionStorage
      sessionStorage.setItem("object",JSON.stringify(data)); //création d'un objet
      location.replace('http://localhost:4200/pageProduits');//envoi sur la page produit
    })
    
  }

}
