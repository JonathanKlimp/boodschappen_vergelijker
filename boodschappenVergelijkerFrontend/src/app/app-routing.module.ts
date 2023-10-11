import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingComponent } from './landing/landing.component';
import { LoginComponent } from './login/login.component';
import { ResultPageComponent } from './result-page/result-page.component';

const routes: Routes = [
  { path: 'landing', component: LandingComponent },
  { path: 'login', component: LoginComponent },
  { path: 'results', component: ResultPageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
