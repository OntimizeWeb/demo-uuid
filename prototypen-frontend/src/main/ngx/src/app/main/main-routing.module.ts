import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService } from 'ontimize-web-ngx';

import { MainComponent } from './main.component';
import { ProfileComponent } from './profile/profile.component';

export const routes: Routes = [
  {
    path: '',
    component: MainComponent,
    canActivate: [AuthGuardService],
    children: [
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      { path: 'home', loadChildren: () => import('./home/home.module').then(m => m.HomeModule) },
      { path: 'locations', loadChildren: () => import('./locations-basic/locations.module').then(m => m.LocationsBasicModule) },
      { path: 'locationsmodal', loadChildren: () => import('./locations-modal/locations.module').then(m => m.LocationsModalModule) },
      { path: 'locationstab', loadChildren: () => import('./locations/locations.module').then(m => m.LocationsTabModule) },
      { path: 'locationssplit', loadChildren: () => import('./locations-split/locations.module').then(m => m.LocationsSplitModule) },
      { path: 'locationsdata', loadChildren: () => import('./locations-data/locations.module').then(m => m.LocationsDataModule) },
      { path: 'tags', loadChildren: () => import('./tags/tags.module').then(m => m.TagsModule) },
      { path: 'locationtags', loadChildren: () => import('./locationtags/locationtags.module').then(m => m.LocationTagsModule) },
      { path: 'admin', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },
      { path: 'settings', loadChildren: () => import('./settings/settings.module').then(m => m.SettingsModule) },
      { path: 'profile', component: ProfileComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
