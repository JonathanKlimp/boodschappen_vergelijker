import { Gebruiker } from "src/app/gebruiker";
import { All, AuthActionTypes, loginFailure, loginSuccess } from "../actions/auth.actions";
import { createReducer, on } from "@ngrx/store";

// export interface State {
//     isAuthenticated: boolean;
//     gebruiker: Gebruiker | null;
//     errorMessage: string | null;
// }

// export const initialState: State = {
//     isAuthenticated: false,
//     gebruiker: null,
//     errorMessage: null
// }

// export function reducer(state = initialState, action: All): State {
//     switch (action.type) {
//         case AuthActionTypes.LOGIN_SUCCESS: {
//             return {
//                 ...state,
//                 isAuthenticated: true,
//                 gebruiker: {
//                     token: action.payload.token,
//                     gebruikersnaam: action.payload.gebruikersnaam,
//                 },
//                 errorMessage: null
//             };
//         }
//         default: {
//             return state;
//         }
//     }
// }

export const initialState: string = 'niet'
export const authReducer = createReducer(
    initialState,
    on(loginSuccess, (state, action) =>
        'wel'
    ),
    on(loginFailure, (state, action) => (
        'fout'
    )
    ));

