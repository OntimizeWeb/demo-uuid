import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { HomeLocationTagsComponent } from './home/home.component';
import { LocationTagsRoutingModule } from './locationtags-routing.module';
import { DetailLocationTagsComponent } from './detail/detail.component';
import { SharedModule } from '../../shared/shared.module';

@NgModule({
  declarations: [HomeLocationTagsComponent, DetailLocationTagsComponent],
  imports: [
    CommonModule,
    SharedModule,
    OntimizeWebModule,
    LocationTagsRoutingModule
  ],
  exports: [],
  providers: [],
  entryComponents: []
})
export class LocationTagsModule { }
