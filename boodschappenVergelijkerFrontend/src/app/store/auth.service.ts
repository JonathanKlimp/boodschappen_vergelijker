import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs'

import { Gebruiker } from '../gebruiker';


@Injectable()
export class AuthService {
  private BASE_URL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  logIn(gebruikersnaam: string, wachtwoord: string): Observable<Gebruiker> {
    console.log('logging in:' + gebruikersnaam + wachtwoord)
    const url = `${this.BASE_URL}/login`;
    return this.http.post<Gebruiker>(url, { gebruikersnaam, wachtwoord });
  }

  registeer(gebruikersnaam: string, wachtwoord: string): Observable<Gebruiker> {
    const url = `${this.BASE_URL}/registreer`;
    return this.http.post<Gebruiker>(url, { gebruikersnaam, wachtwoord });
  }
}