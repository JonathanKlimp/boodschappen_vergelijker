import { Component, OnInit } from '@angular/core';
import { Gebruiker } from '../gebruiker';
import { Store } from '@ngrx/store';
import { AppState } from '../store/app.states';
import { LogIn } from '../store/actions/auth.actions';
import * as AuthActions from '../store/actions/auth.actions'


/**
* @title login demo
*/
@Component({
  selector: 'login-demo',
  styleUrls: ['./login.component.css'],
  templateUrl: './login.component.html',
})
export class LoginComponent implements OnInit {
  gebruiker: Gebruiker = new Gebruiker();

  constructor(
    private store: Store<AppState>) { }

  ngOnInit() {

  }

  // onSubmit(): void {
  //   const payload = {
  //     gebruikersnaam: this.gebruiker.gebruikersnaam,
  //     wachtwoord: this.gebruiker.wachtwoord
  //   };
  //   this.store.dispatch(new LogIn(payload))
  // }

  onSubmit(): void {
    console.log("naam: " + this.gebruiker.gebruikersnaam)
    console.log("ww:" + this.gebruiker.wachtwoord)
    this.store.dispatch(AuthActions.login({ gebruikersnaam: this.gebruiker.gebruikersnaam, wachtwoord: this.gebruiker.wachtwoord }))
  }

}