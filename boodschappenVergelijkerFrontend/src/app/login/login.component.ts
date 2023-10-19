import { Component, OnInit } from '@angular/core';
import { Gebruiker } from '../gebruiker';
import { Store, select } from '@ngrx/store';
import { AppState } from '../store/app.states';
import * as AuthActions from '../store/actions/auth.actions'
import { Observable } from 'rxjs';


@Component({
  selector: 'login-demo',
  styleUrls: ['./login.component.css'],
  templateUrl: './login.component.html',
})
export class LoginComponent implements OnInit {
  gebruiker: Gebruiker = new Gebruiker();
  logInSuccess!: Observable<string>;

  constructor(private store: Store<AppState>) {
    this.logInSuccess = this.store.pipe(select(state => state.inGelogged));
    this.logInSuccess.subscribe(log => console.log('State log:' + log))
  }

  ngOnInit() {
  }

  onSubmit(): void {


    console.log("naam: " + this.gebruiker.gebruikersnaam)
    console.log("ww:" + this.gebruiker.wachtwoord)
    this.store.dispatch(AuthActions.login({ gebruikersnaam: this.gebruiker.gebruikersnaam, wachtwoord: this.gebruiker.wachtwoord }))
    this.logInSuccess = this.store.pipe(select(state => { console.log(state.inGelogged); return state.inGelogged }));
    console.log('Dikke success' + this.logInSuccess)
  }

}