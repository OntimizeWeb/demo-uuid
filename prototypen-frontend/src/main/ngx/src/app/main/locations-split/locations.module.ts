import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LocationsRoutingModule } from './locations-routing.module';
import { HomeLocationsComponent } from './home/home.component';
import { DetailLocationsComponent } from './detail/detail.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { SharedModule } from '../../shared/shared.module';



@NgModule({
  declarations: [HomeLocationsComponent, DetailLocationsComponent],
  imports: [
    CommonModule,
    SharedModule,
    OntimizeWebModule,
    LocationsRoutingModule
  ]
})
export class LocationsSplitModule { }
