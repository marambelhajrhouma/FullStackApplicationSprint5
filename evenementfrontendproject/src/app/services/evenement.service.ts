import { Injectable } from '@angular/core';
import { Evenement } from '../models/evenement.model';

import { Observable } from 'rxjs'; 
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { apiURL } from '../config';

const httpOptions = {
  headers: new HttpHeaders( {'Content-Type': 'application/json'} ) 
};
@Injectable({
  providedIn: 'root'
})
export class EvenementService {
  evenements: Evenement[]=[];
  /* themes : Theme[]; */

  apiURL: string ='http://localhost:8083/themes/api';

  //URL de spring Data REST
  apiURLTheme: string='http://localhost:8083/themes/theme';

  constructor(private http: HttpClient,
              
  ) {}

 
  listeEvenement(): Observable<Evenement[]>{ 
    return this.http.get<Evenement[]>(this.apiURL + "/all"); 
  }

  
  
}
