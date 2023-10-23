import { loginFailure, loginSuccess } from "../actions/auth.actions";

import { createReducer, on } from "@ngrx/store";

export const initialState: string = 'niet'
console.log('Init state:' + initialState)
export const authReducer = createReducer(
    initialState,
    on(loginSuccess, (state, action) => {
        console.log('State: ' + state + 'Actiion:' + action.gebruikersnaam)
        return 'wel'

    }
    ),
    on(loginFailure, (state, action) => {
        console.log('fail')
        return 'fout'

    }
    ));

export const authReducers = {
    authReducer: authReducer
}


