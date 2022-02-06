import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LesBonnesRef';

  //mes variables boolean
  pasConnecte: boolean = true;
  admin: boolean = false;
  utilisateur: String = "";
  portefeuille: number = 0;

  //au chargement de la page
  ngOnInit(): void {
    this.testConnecter(); //appelle de ma méthode permettant de voir si l'utilisateur est connecté
  }

  testConnecter() {
    ///récupération des Stockage de Session///
    let objectSesion = JSON.parse(sessionStorage.getItem("object") || '{}')
    let role = objectSesion.role;
    let mail = objectSesion.mail;
    this.portefeuille = objectSesion.portefeuille;
    console.log(objectSesion);
    console.log("portefeuille :" + this.portefeuille);
    this.utilisateur = objectSesion.nom + " " + objectSesion.prenom;

    //si connecter 
    if (mail != null && role != null) {
      this.pasConnecte = false;//fait disparaitre la page de connection dans la NavBar
      if (role == "admin")//si je suis un admin
      {
        this.admin = true; //fait apparaitre la page de getionaire administrateur dans la NavBar
        alert("Bienvenue administrateur " + this.utilisateur);
      }

      else //si je suis un autre utilisateur 
      {
        alert("Bienvenue utilisateur " + this.utilisateur);
      }
    }
  }

  deconnectionUtilisateur() {
    // Supprimer toutes les données de sessionStorage
    console.log("demande de deconnection");
    sessionStorage.clear();
    location.replace('http://localhost:4200/pageConnexion');
    alert("Vous êtes désormais déconnecter");
  }

}

