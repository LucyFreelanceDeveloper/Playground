import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HomeComponent } from './home/home.component';
import { AppComponent } from './app.component';
import { HousingLocationComponent } from './housing-location/housing-location.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HomeComponent,
    HousingLocationComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
