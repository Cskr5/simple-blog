import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PostingFormComponent} from "./components/posting-form/posting-form.component";
import {PostingListComponent} from "./components/posting-list/posting-list.component";
import {PageNotFoundComponent} from "./components/page-not-found/page-not-found.component";
import {PostDetailsComponent} from "./post-details/post-details.component";

const routes: Routes = [
  {path: '', component: PostingListComponent},
  {path: 'posting-form', component: PostingFormComponent},
  {path: 'posting-list', component: PostingListComponent},
  {path: 'post/:id', component: PostDetailsComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
