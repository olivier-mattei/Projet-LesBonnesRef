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
  }

  creationUtilisateur(utilisateur: any) {
    // console.log(utilisateur.value);
    let donneesUtilisateur = utilisateur.value;
    // console.log(donneesUtilisateur);
    this.serviceUtilisateur.ajoutUtilisateur(donneesUtilisateur).subscribe(data =>{
      console.log("reussi");
    })
    
  }

}
