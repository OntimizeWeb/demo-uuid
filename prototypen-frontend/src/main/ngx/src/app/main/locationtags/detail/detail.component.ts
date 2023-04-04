import { Component, OnInit, ViewChild, Injector } from '@angular/core';
import { OComboComponent, OFormComponent, OFormDataComponent } from 'ontimize-web-ngx';
import { MainService } from '../../../shared/services/main.service';

@Component({
  selector: 'detail-locationtags',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.scss']
})
export class DetailLocationTagsComponent implements OnInit {
  @ViewChild('form', {static: false})
  form : OFormComponent;
  mainService: MainService;
  locationtagsCombo : OComboComponent;

  constructor(private injector : Injector) {
    this.mainService = injector.get(MainService);
  }

  ngOnInit() {
  }

  onInitialMode() {
    //(this.form.getFieldReference('ref_location_id') as OFormDataComponent).setEnabled(false);
    //(this.form.getFieldReference('ref_tag_id') as OFormDataComponent).setEnabled(false);
  }

  onInsertMode() {
    //let location = (this.form.getFieldReference('ref_location_id') as OFormDataComponent);
    //if (location.getValue() === undefined) {
    //  location.setEnabled(true);
    //}
    //(this.form.getFieldReference('ref_tag_id') as OFormDataComponent).setEnabled(true);
  }
}
