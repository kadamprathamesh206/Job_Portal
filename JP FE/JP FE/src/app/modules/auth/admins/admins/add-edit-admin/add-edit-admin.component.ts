import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-edit-admin',
  templateUrl: './add-edit-admin.component.html',
  styleUrls: ['./add-edit-admin.component.scss']
})
export class AddEditAdminComponent implements OnInit {

  adminForm = new FormGroup({
    id: new FormControl(""),
    name: new FormControl("", [Validators.required]),
    email: new FormControl("", [Validators.required, Validators.pattern("[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[a-z]{2,3}")]),
    password: new FormControl("", [Validators.required]),
    no: new FormControl("", [Validators.required]),
    address: new FormControl("", [Validators.required]),
  });

  constructor(
    public dialogRef: MatDialogRef<AddEditAdminComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) { }

  ngOnInit(): void {
    console.log("Dialog Opened", this.data);
    if (this.data) {
      this.adminForm.get("id")?.patchValue(this.data.id);
      this.adminForm.get("name")?.patchValue(this.data.name);
      this.adminForm.get("email")?.patchValue(this.data.email);
      this.adminForm.get("password")?.patchValue(this.data.password);
      this.adminForm.get("no")?.patchValue(this.data.no);
      this.adminForm.get("address")?.patchValue(this.data.address);
    } else {
      this.adminForm.get("id")?.patchValue(0);
    }
  }

}
