// import { Injectable } from '@angular/core';
// import { Action } from '@ngrx/store';
// import { Router } from '@angular/router';
// import { Actions, ofType } from '@ngrx/effects';
// import {createEffect} from '@ngrx/effects'
// import { Observable } from 'rxjs';
// import 'rxjs/add/observable/of';
// import 'rxjs/add/operator/map';
// import 'rxjs/add/operator/switchMap';
// import 'rxjs/add/operator/catch';
// import { tap } from 'rxjs/operators';

// import { AuthService } from '../auth.service';
// import { AuthActionTypes } from '../actions/auth.actions';

// import {
//     LogIn, LogInSuccess, LogInFailure,
// } from '../actions/auth.actions';


// @Injectable()
// export class AuthEffects {

//     constructor(
//         private actions: Actions,
//         private authService: AuthService,
//         private router: Router,
//     ) { }

//     login$ = createEffect(() =>
//     this.actions$.pipe(
//       ofType(AuthActions.login),
//       switchMap(action => this.authService.logIn(action.payload.email, action.payload.password)
//         .pipe(
//           map(user => {
//             console.log(user);
//             return AuthActions.loginSuccess({ token: user.token, email: action.payload.email });
//           }),
//           catchError(error => {
//             console.error(error);
//             return of(AuthActions.loginFailure({ error }));
//           })
//         )
//       )
//     )
//   );



//     @Effect()
//     LogIn: Observable<any> = this.actions
//         .ofType(AuthActionTypes.LOGIN)
//         .map((action: LogIn) => action.payload)
//         .switchMap(payload => {
//             return this.authService.logIn(payload.email, payload.password)
//                 .map((user) => {
//                     console.log(user);
//                     return new LogInSuccess({ token: user.token, email: payload.email });
//                 })
//                 .catch((error) => {
//                     console.log(error);
//                     return Observable.of(new LogInFailure({ error: error }));
//                 });
//         });


//     @Effects({ dispatch: false })
//     LogInSuccess: Observable<any> = this.actions.pipe(
//         ofType(AuthActionTypes.LOGIN_SUCCESS),
//         tap((user) => {
//             localStorage.setItem('token', user.payload.token);
//             this.router.navigateByUrl('/');
//         })
//     );


// }
// import { Injectable } from '@angular/core';
// import { Actions, createEffect, ofType } from '@ngrx/effects';
// import { catchError, map, switchMap } from 'rxjs/operators';
// import { of } from 'rxjs';
// import { AuthService } from '../auth.service';
// import * as AuthActions from '../actions/auth.actions';
// import { Gebruiker } from 'src/app/gebruiker';
// import { Action } from '@ngrx/store';



// @Injectable()
// export class AuthEffects {

//     login$ = createEffect(() =>
//         this.actions$.pipe(
//             ofType(AuthActions.login),
//             mergeMap((action) => this.authService
//                 .logIn(action.payload.gebruikersnaam, action.payload.wachtwoord)
//                 .pipe(
//                     map(gebruiker => {
//                         console.log(gebruiker);
//                         return AuthActions.loginSuccess({ token: gebruiker.token, gebruikersnaam: action.payload.gebruikersnaam });
//                     }),
//                     catchError(error => {
//                         console.error(error);
//                         return of(AuthActions.loginFailure({ error }));
//                     })
//                 )
//             )
//         )
//     );

//     constructor(
//         private actions$: Actions,
//         private authService: AuthService
//     ) { }

// }

import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { catchError, map, switchMap } from 'rxjs/operators';
import { of } from 'rxjs';

import * as AuthActions from '../actions/auth.actions';
import { AuthService } from '../auth.service';

@Injectable()
export class AuthEffects {

    login$ = createEffect(() =>
        this.actions$.pipe(
            ofType(AuthActions.login),
            switchMap(action =>
                this.authService.logIn(action.gebruikersnaam, action.wachtwoord)
                    .pipe(
                        map(() => AuthActions.loginSuccess),
                        catchError(() => of(AuthActions.loginFailure()))
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
                        map(() => AuthActions.registeerSuccess()),
                        catchError(() => of(AuthActions.registeerFailure()))
                    )
            )
        )
    );

    constructor(
        private actions$: Actions,
        private authService: AuthService
    ) { }
}