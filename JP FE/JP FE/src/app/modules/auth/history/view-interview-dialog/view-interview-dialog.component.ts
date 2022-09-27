import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-view-interview-dialog',
  templateUrl: './view-interview-dialog.component.html',
  styleUrls: ['./view-interview-dialog.component.scss']
})
export class ViewInterviewDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<ViewInterviewDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) { }

  ngOnInit(): void {
    if (this.data) {
      console.log("dialog", this.data);
    }
  }

}
