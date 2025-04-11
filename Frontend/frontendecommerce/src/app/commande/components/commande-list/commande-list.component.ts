import { Component, OnInit } from '@angular/core';
import { Commande } from '../../models/commande.model';
import { CommandeService } from '../../services/commande.service';

@Component({
  selector: 'app-commande-list',
  templateUrl: './commande-list.component.html'
})
export class CommandeListComponent implements OnInit {
  commandes: Commande[] = [];

  constructor(private commandeService: CommandeService) {}

  ngOnInit(): void {
    this.commandeService.getAll().subscribe(data => {
      this.commandes = data;
    });
  }
}

