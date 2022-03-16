import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { BursarAccountantFormComponent } from './bursar-accountant-form/bursar-accountant-form.component';
import { BursarAccountantViewpageComponent } from './bursar-accountant-viewpage/bursar-accountant-viewpage.component';

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    NavBarComponent,
    RegistrationFormComponent,
    BursarAccountantFormComponent,
    BursarAccountantViewpageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
