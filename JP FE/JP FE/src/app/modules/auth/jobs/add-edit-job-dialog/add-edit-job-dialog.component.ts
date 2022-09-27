import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-edit-job-dialog',
  templateUrl: './add-edit-job-dialog.component.html',
  styleUrls: ['./add-edit-job-dialog.component.scss']
})
export class AddEditJobDialogComponent implements OnInit {

  jobForm = new FormGroup({
    id: new FormControl(""),
    email: new FormControl(""),
    experience: new FormControl("", [Validators.required]),
    name: new FormControl("", [Validators.required]),
    requirements: new FormControl("", [Validators.required]),
  });

  constructor(
    public dialogRef: MatDialogRef<AddEditJobDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) { }

  ngOnInit(): void {
  }

}
