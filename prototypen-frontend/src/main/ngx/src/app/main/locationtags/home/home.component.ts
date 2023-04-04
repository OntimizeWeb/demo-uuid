import { Component, ViewChild } from '@angular/core';
import { FilterExpressionUtils, Expression, Util, OTableComponent } from 'ontimize-web-ngx';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'home-locationtags',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeLocationTagsComponent  {
  @ViewChild('locationtagsTable', {static:false})
  locationtagsTable : OTableComponent;

  constructor( protected dialog: MatDialog) { 
  }

  createFilter(values: Array<{ attr; value }>): Expression {
    // Prepare simple expressions from the filter components values
    let filters: Array<Expression> = [];
    values.forEach(fil => {
      if (Util.isDefined(fil.value)) {
        if (
          fil.attr === "locationtag_id" ||
          fil.attr === "firstname" || 
          fil.attr === "laststname" || 
          fil.attr === "email" 
        ) {
          filters.push(
            FilterExpressionUtils.buildExpressionLike(fil.attr, fil.value)
          );
        }
      }
    });

    // Build complex expression
    if (filters.length > 0) {
      return filters.reduce((exp1, exp2) =>
        FilterExpressionUtils.buildComplexExpression(
          exp1,
          exp2,
          FilterExpressionUtils.OP_AND
        )
      );
    } else {
      return null;
    }
  }

  reloadLocationTags() {
    this.locationtagsTable.reloadData();
  }
}
