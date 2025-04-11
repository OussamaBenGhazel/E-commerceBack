import { Commande } from "../../commande/models/commande.model";

export enum StatusFacture {
  PAYE = 'PAYE',
  EN_ATTENTE = 'EN_ATTENTE'
}

export interface Facture {
  id?: number;
  montantTotal: number;
  dateFacture: string;
  status: StatusFacture;
  commande: Commande;
}
