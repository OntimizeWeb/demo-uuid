import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TagsRoutingModule } from './tags-routing.module';
import { HomeTagsComponent } from './home/home.component';
import { DetailTagsComponent } from './detail/detail.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { SharedModule } from '../../shared/shared.module';



@NgModule({
  declarations: [HomeTagsComponent, DetailTagsComponent],
  imports: [
    CommonModule,
    SharedModule,
    OntimizeWebModule,
    TagsRoutingModule
  ]
})
export class TagsModule { }
