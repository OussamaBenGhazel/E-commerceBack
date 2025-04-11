import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommandeDetailComponent } from './commande/components/commande-detail/commande-detail.component';
import { CommandeListComponent } from './commande/components/commande-list/commande-list.component';

const routes: Routes = [
  { path: 'commandes', loadChildren: () => import('./commande/commande.module').then(m => m.CommandeModule) },
  { path: 'factures', loadChildren: () => import('./facture/facture.module').then(m => m.FactureModule) },
  { path: '', component: CommandeListComponent }, // /commande
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
