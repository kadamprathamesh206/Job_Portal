import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { JobsService } from 'src/app/services/jobs.service';
import { AddEditJobDialogComponent } from './add-edit-job-dialog/add-edit-job-dialog.component';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.scss']
})
export class JobsComponent implements OnInit {

  jobsList: any = [];
  originalJobsList: any = [];

  userType: string = "2";
  userEmail: string = "";
  user: any;

  searchvalue: any = "";

  constructor(
    private jobsService: JobsService,
    private dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.userType = JSON.parse(localStorage.getItem("user") || "").type;
    this.userEmail = JSON.parse(localStorage.getItem("user") || "").email;
    this.user = JSON.parse(localStorage.getItem("user") || "");
    if (this.userType == "2") {
      this.getAllJobs();
    } else {
      this.getAllJobsByCompany();
    }
  }

  getAllJobs() {
    this.jobsService.getAllJobs().subscribe((res: any) => {
      if (res) {
        this.jobsList = res;
        this.originalJobsList = res;
      }
    });
  }

  getAllJobsByCompany() {
    this.jobsService.getJobsByCompany(this.userEmail).subscribe((res: any) => {
      if (res) {
        this.jobsList = res;
      }
    });
  }

  add() {
    const dialogRef = this.dialog.open(AddEditJobDialogComponent, {
      width: '30%',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
      if (result) {
        result['email'] = this.userEmail;
        result['company'] = JSON.parse(localStorage.getItem("user") || "");
        this.jobsService.addJob(result).subscribe(res => {
          if (res) {
            window.alert("Job added successfully");
            this.getAllJobsByCompany();
          }
        });
      }
    });
  }

  edit(obj: any) { }

  delete(id: string) { 
    if (window.confirm("Are you sure you want to delete this job ?")) {
      // this.jobsService.dele
    }
  }

  apply(data: any) {
    if (window.confirm("Are you sure you want to apply to this job ?")) {
      const obj = {
        email: data.email,
        name: data.name,
        experience: data.experience,
        requirements: data.requirements,
        jobseeker: { id: this.user.id }
      }
      this.jobsService.applyJob(obj).subscribe((res: any) => {
        if (res) {
          window.alert("Job applied successfully");
          this.getAllJobs();
        }
      });
    } 
  }

  searchList() {
    console.log("search", this.searchvalue);
    this.jobsList = this.originalJobsList.filter((job: any) =>
     job.name.toLowerCase().includes(this.searchvalue.toLowerCase()) || job.company.comapny_name.toLowerCase().includes(this.searchvalue.toLowerCase()));
  }
}
