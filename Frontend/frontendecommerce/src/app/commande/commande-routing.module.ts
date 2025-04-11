import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommandeDetailComponent } from './components/commande-detail/commande-detail.component';
import { CommandeCreateComponent } from './components/commande-create/commande-create.component';
import { CommandeListComponent } from './components/commande-list/commande-list.component';


const routes: Routes = [
  { path: '', component: CommandeListComponent }, // /commande
  { path: 'ajouter', component: CommandeCreateComponent }, // /commande/ajouter
  { path: 'details/:id', component: CommandeDetailComponent } // /commande/details/1
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CommandeRoutingModule {}
