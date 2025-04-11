import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FactureRoutingModule } from './facture-routing.module';
import { FactureListComponent } from './components/facture-list/facture-list.component';
import { FactureCreateComponent } from './components/facture-create/facture-create.component';
import { FactureDetailComponent } from './components/facture-detail/facture-detail.component';


@NgModule({
  declarations: [
    FactureListComponent,
    FactureCreateComponent,
    FactureDetailComponent
  ],
  imports: [
    CommonModule,
    FactureRoutingModule
  ]
})
export class FactureModule { }
