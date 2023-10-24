import { NgModule } from '@angular/core';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { BrowserModule } from '@angular/platform-browser';
import { MatGridListModule } from '@angular/material/grid-list'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingComponent } from './landing/landing.component';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { SearchComponent } from './landing/search/search.component';
import { TitleComponent } from './landing/title/title.component';
import { BannerComponent } from './landing/banner/banner.component';
import { LoginButtonComponent } from './landing/banner/login-button/login-button.component';
import { MatButtonModule } from '@angular/material/button';
import { LogoComponent } from './landing/logo/logo.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ResultPageComponent } from './result-page/result-page.component';
import { ProductComponent } from './result-page/product/product.component';
import { ShoppingListComponent } from './result-page/shopping-list/shopping-list.component';
import { GebruikerComponent } from './gebruiker/gebruiker.component';
import { SupermarktComponent } from './result-page/supermarkt/supermarkt.component';
import { HttpClientModule } from '@angular/common/http'; import { SearchService } from './landing/search/search.service';
import { MatCard, MatCardModule } from '@angular/material/card';
import { StoreModule } from '@ngrx/store';
import { RegistreerComponent } from './registreer/registreer.component';
import { AuthService } from './store/auth.service';
import { EffectsModule } from '@ngrx/effects';
import { AuthEffects } from './store/effects/auth.effects';
import { authReducer, authReducers } from './store/reducers/auth.reducers';

@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    SearchComponent,
    TitleComponent,
    BannerComponent,
    LoginButtonComponent,
    LoginComponent,
    LogoComponent,
    NavbarComponent,
    ResultPageComponent,
    ProductComponent,
    ShoppingListComponent,
    GebruikerComponent,
    SupermarktComponent,
    RegistreerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatGridListModule,
    MatInputModule,
    MatFormFieldModule,
    MatProgressSpinnerModule,
    FormsModule,
    MatButtonModule,
    HttpClientModule,
    MatCardModule,
    StoreModule.forRoot(authReducers),
    EffectsModule.forRoot([AuthEffects])
  ],
  providers: [AuthService],
  bootstrap: [AppComponent, SearchComponent, TitleComponent, LogoComponent, LoginComponent, NavbarComponent, MatProgressSpinnerModule]
})
export class AppModule { }
