import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PostingFormComponent} from "./posting-form/posting-form.component";
import {PostingListComponent} from "./posting-list/posting-list.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";

const routes: Routes = [
  {path: '', component: PostingListComponent},
  {path: 'posting-form', component: PostingFormComponent},
  {path: 'posting-list', component: PostingListComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
