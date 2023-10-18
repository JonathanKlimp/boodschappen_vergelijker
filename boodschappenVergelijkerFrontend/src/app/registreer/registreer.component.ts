import { Component, OnInit } from '@angular/core';
import { Gebruiker } from '../gebruiker';
import { Store } from '@ngrx/store';
import { AppState } from '../store/app.states';
import { registreer } from '../store/actions/auth.actions';
import * as AuthActions from '../store/actions/auth.actions'

@Component({
  selector: 'app-registreer',
  templateUrl: './registreer.component.html',
  styleUrls: ['./registreer.component.css']
})
export class RegistreerComponent implements OnInit {
  gebruiker: Gebruiker = new Gebruiker();

  constructor(private store: Store<AppState>) { }

  ngOnInit() {

  }

  onSubmit(): void {
    console.log("naam: " + this.gebruiker.gebruikersnaam)
    console.log("ww:" + this.gebruiker.wachtwoord)
    this.store.dispatch(AuthActions.registreer({ gebruikersnaam: this.gebruiker.gebruikersnaam, wachtwoord: this.gebruiker.wachtwoord }))
  }
}
