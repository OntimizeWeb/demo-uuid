import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeLocationTagsComponent } from './home/home.component';
import { NewLocationTagsComponent } from './new/new.component';
import { DetailLocationTagsComponent } from './edit/detail.component';
import { DetailTagsComponent } from '../tags/detail/detail.component';

const routes: Routes = [
  { path: '', component: HomeLocationTagsComponent },
  { path: 'new', component: NewLocationTagsComponent },
  { path: ':ref_location_id/:location_tag_id', component: DetailLocationTagsComponent },
  { path: ':ref_location_id/:location_tag_id/:tag_id', component: DetailTagsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class LocationTagsRoutingModule { }
