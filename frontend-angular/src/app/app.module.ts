import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PostingFormComponent } from './posting-form/posting-form.component';
import { PostingListComponent } from './posting-list/posting-list.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PostingFormComponent,
    PostingListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
