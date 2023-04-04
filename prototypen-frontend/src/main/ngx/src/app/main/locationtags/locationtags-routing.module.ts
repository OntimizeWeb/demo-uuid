import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeLocationTagsComponent } from './home/home.component';
import { DetailLocationTagsComponent } from './detail/detail.component';

const routes: Routes = [
  { path: '', component: HomeLocationTagsComponent },
  { path: 'new', component: DetailLocationTagsComponent },
  { path: ':ref_location_id/:location_tag_id', component: DetailLocationTagsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class LocationTagsRoutingModule { }
