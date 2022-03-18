import { ViewComponent } from './view/view.component';
import { BursarformComponent } from './bursarform/bursarform.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { AboutComponent } from './about/about.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';



const routes: Routes = [
  {path:'landingpage',component:LandingPageComponent},
  {path:'about',component:AboutComponent},
  {path:'registration',component:RegisterComponent},
  {path:'login',component:LoginComponent},
  { path:'appview', component:ViewComponent},
  { path:'bursarform', component:BursarformComponent},
  { path: '', redirectTo:"/landingpage", pathMatch:"full"},
  { path:'**', component:NotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
