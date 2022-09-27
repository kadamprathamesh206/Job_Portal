import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-interview-dialog',
  templateUrl: './interview-dialog.component.html',
  styleUrls: ['./interview-dialog.component.scss']
})
export class InterviewDialogComponent implements OnInit {

  interviewForm = new FormGroup({
    employper_name: new FormControl("", [Validators.required]),
    interview_date: new FormControl("", [Validators.required]),
    hr: new FormControl("", [Validators.required]),
    min: new FormControl("", [Validators.required]),
  });

  constructor(
    public dialogRef: MatDialogRef<InterviewDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) { }

  ngOnInit(): void {
    if (this.data) {
      this.interviewForm.get("employper_name")?.patchValue(this.data.comapny_name);
    }
  }

}
