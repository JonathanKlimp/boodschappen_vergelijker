import { Action, createAction, props } from '@ngrx/store';
import { Gebruiker } from 'src/app/gebruiker';

export enum AuthActionTypes {
    LOGIN = '[Auth] login',
    LOGIN_SUCCESS = '[Auth] Login Success',
    LOGIN_FAILURE = '[Auth] Login Failure',
    LOGOUT = '[Auth] Logout',
    REGISTREER = '[Auth] Registeer',
    REGISTREER_SUCCESS = '[Auth] Registeer Success',
    REGISTREER_FAILURE = '[Auth] Registreer Failure',

}

export const login = createAction(
    AuthActionTypes.LOGIN,
    props<{ gebruikersnaam: string, wachtwoord: string }>()
)

export const loginSuccess = createAction(
    AuthActionTypes.LOGIN_SUCCESS,
    props<{ gebruikersnaam: string, wachtwoord: string }>()
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

