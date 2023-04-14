import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { HomeLocationTagsComponent } from './home/home.component';
import { LocationTagsRoutingModule } from './locationtags-routing.module';
import { SharedModule } from '../../shared/shared.module';
import { NewLocationTagsComponent } from './new/new.component';
import { DetailLocationTagsComponent } from './edit/detail.component';
import { TagsModule } from '../tags/tags.module';

@NgModule({
  declarations: [HomeLocationTagsComponent, NewLocationTagsComponent, DetailLocationTagsComponent],
  imports: [
    CommonModule,
    SharedModule,
    OntimizeWebModule,
    LocationTagsRoutingModule,
    TagsModule
  ],
  exports: [],
  providers: [],
  entryComponents: []
})
export class LocationTagsModule { }
