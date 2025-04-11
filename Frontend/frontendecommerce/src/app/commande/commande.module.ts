import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { CommandeRoutingModule } from './commande-routing.module';
import { CommandeListComponent } from './components/commande-list/commande-list.component';
import { CommandeCreateComponent } from './components/commande-create/commande-create.component';
import { CommandeDetailComponent } from './components/commande-detail/commande-detail.component';


@NgModule({
  declarations: [
    CommandeListComponent,
    CommandeCreateComponent,
    CommandeDetailComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    CommandeRoutingModule
  ]
})
export class CommandeModule { }
