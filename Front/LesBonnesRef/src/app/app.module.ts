import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ProduitsComponent } from './components/produits/produits.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import { FormsModule } from '@angular/forms';
import { InscriptionComponent } from './components/inscription/inscription.component';

@NgModule({
  declarations: [
    AppComponent,
    ProduitsComponent,
    AccueilComponent,
    InscriptionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
