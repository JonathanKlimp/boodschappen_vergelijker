import { Action, createAction, props } from '@ngrx/store';
import { Gebruiker } from 'src/app/gebruiker';

export enum AuthActionTypes {
    LOGIN = '[Auth] Login',
    LOGIN_SUCCESS = '[Auth] Login Success',
    LOGIN_FAILURE = '[Auth] Login Failure',
    LOGOUT = '[Auth] Logout',
    REGISTREER = '[Auth] Registeer',
    REGISTREER_SUCCESS = '[Auth] Registeer Success',
    REGISTREER_FAILURE = '[Auth] Registreer Failure',

}

export class LogIn implements Action {
    readonly type = AuthActionTypes.LOGIN;
    constructor(public payload: Gebruiker) { }
}

export class LogInSuccess implements Action {
    readonly type = AuthActionTypes.LOGIN_SUCCESS;
    constructor(public payload: any) { }
}

export class LoginFailure implements Action {
    readonly type = AuthActionTypes.LOGIN_FAILURE;
    constructor(public payload: any) { }
}

export type All =
    | LogIn
    | LogInSuccess;


export const login = createAction(
    AuthActionTypes.LOGIN,
    props<{ gebruikersnaam: string, wachtwoord: string }>()
)

export const loginSuccess = createAction(
    AuthActionTypes.LOGIN_SUCCESS,
    props<{ token: string, gebruikersnaam: string }>()
)

export const loginFailure = createAction(
    AuthActionTypes.LOGIN_FAILURE,
    props<{ error: any }>
)

export const registreer = createAction(
    AuthActionTypes.REGISTREER,
    props<{ gebruikersnaam: string, wachtwoord: string }>()
)

export const registeerSuccess = createAction(
    AuthActionTypes.REGISTREER_SUCCESS,
    props<{ gebruikersnaam: string, wachtwoord: string }>
)

export const registeerFailure = createAction(
    AuthActionTypes.REGISTREER_FAILURE,
    props<{ error: any }>
)

export const logout = createAction(AuthActionTypes.LOGOUT);

