import { Injectable } from '@angular/core';
import { Commande } from '../models/commande.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {
  private apiUrl = 'http://localhost:8093/commande/commandes'; // adapter à ton backend

  constructor(private http: HttpClient) {}

  getAll(): Observable<Commande[]> {
    return this.http.get<Commande[]>(`${this.apiUrl}/all`);
  }

  create(commande: Commande): Observable<Commande> {
    return this.http.post<Commande>(`${this.apiUrl}/add`, commande);
  }

  getById(id: number): Observable<Commande> {
    return this.http.get<Commande>(`${this.apiUrl}/${id}`);
  }
}

