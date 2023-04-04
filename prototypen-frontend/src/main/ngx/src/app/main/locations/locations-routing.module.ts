import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DetailLocationsComponent } from './detail/detail.component';
import { HomeLocationsComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: HomeLocationsComponent },
  { path: 'new', component: DetailLocationsComponent },
  { path: ':location_id', component: DetailLocationsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LocationsRoutingModule { }
