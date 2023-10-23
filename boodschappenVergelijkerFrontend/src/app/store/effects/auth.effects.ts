import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { catchError, map, mergeMap, switchMap } from 'rxjs/operators';
import { of } from 'rxjs';

import * as AuthActions from '../actions/auth.actions';
import { AuthService } from '../auth.service';

@Injectable()
export class AuthEffects {

    login$ = createEffect(() =>
        this.actions$.pipe(
            ofType(AuthActions.login),
            mergeMap(action =>
                this.authService.logIn(action.gebruikersnaam, action.wachtwoord)
                    .pipe(
                        map(success => {
                            console.log('Succes:' + success)
                            return AuthActions.loginSuccess
                        }),
                        catchError(error => {
                            console.log('Error:' + error)
                            return of(AuthActions.loginFailure());
                        })
                    )
            )
        )
    );

    registreer$ = createEffect(() =>
        this.actions$.pipe(
            ofType(AuthActions.registreer),
            switchMap(action =>
                this.authService.registeer(action.gebruikersnaam, action.wachtwoord)
                    .pipe(
                        map((success) => {
                            console.log('Success:' + success)
                            return AuthActions.registeerSuccess()
                        }),
                        catchError((error) => {
                            console.log('Error:' + error)
                            return of(AuthActions.registeerFailure())
                        })
                    )
            )
        )
    );

    constructor(
        private actions$: Actions,
        private authService: AuthService
    ) { }
}