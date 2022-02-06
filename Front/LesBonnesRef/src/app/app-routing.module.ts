import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProduitsComponent } from './components/produits/produits.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { PanierComponent } from './components/panier/panier.component';

const routes: Routes = [
  {path: '', component: AccueilComponent},
  {path: 'pageProduits', component:ProduitsComponent},
  {path: 'pageConnexion', component: ConnexionComponent},
  {path: 'panier', component: PanierComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
