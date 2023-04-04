import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DetailTagsComponent } from './detail/detail.component';
import { HomeTagsComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: HomeTagsComponent },
  { path: 'new', component: DetailTagsComponent },
  { path: ':tag_id', component: DetailTagsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TagsRoutingModule { }
