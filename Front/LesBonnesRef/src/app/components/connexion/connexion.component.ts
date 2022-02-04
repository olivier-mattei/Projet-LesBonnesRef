import { Component, OnInit } from '@angular/core';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {

  constructor(private serviceUtilisateur: UtilisateurService) { }

  ngOnInit(): void 
  {
    this.serviceUtilisateur.recuperationDeToutLesUtilisateurs();//récupération de tous les utilisateurs partie service
  }
  
  connexionUtilisateur(champConnexion:any)
  {
    let tableau=this.serviceUtilisateur.UserArray._embedded.utilisateurs;// mon tableau 
    console.log("champ connexion test");
    console.log(champConnexion.value);
    
    //donnée recup
    let varMail= champConnexion.value.mail;
    let varMotDePasse = champConnexion.value.motDePasse;

    for(var iter=0;tableau.length>iter;iter++)
    { 
      //console.log("mail de la bdd: "+tableau[iter].mail +"mot de passe "+tableau[iter].motDePasse);
      //test d'égalité
      if (tableau[iter].mail==varMail)//parcour le tableau ligne par ligne
      {
        console.log("mail trouvé à l'iter:"+iter);
        if(tableau[iter].motDePasse==varMotDePasse)
        {
          console.log("mot de passe trouvé à l'iter:"+iter);
          
          // Enregistrement des données dans sessionStorage
          sessionStorage.setItem("object",JSON.stringify(tableau[iter])); //création d'un objet
          location.replace('http://localhost:4200/pageProduits'); //envoi sur la page produit
        }

        else{console.error("mot de passe non valide")}
      }

      else{console.error("mail trouvé non trouvé pour iter: "+iter)};
    }
  
  }

}
