import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProduitsComponent } from './components/produits/produits.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import { InscriptionComponent } from './components/inscription/inscription.component';

const routes: Routes = [
  {path: '', component: AccueilComponent},
  {path: 'pageProduits', component:ProduitsComponent},
  {path: 'pageInscription', component: InscriptionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
