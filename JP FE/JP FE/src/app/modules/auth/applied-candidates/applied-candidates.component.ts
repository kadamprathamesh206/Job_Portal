import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/internal/Subscription';
import { InterviewService } from 'src/app/services/interview.service';
import { JobsService } from 'src/app/services/jobs.service';
import { InterviewDialogComponent } from './interview-dialog/interview-dialog.component';

@Component({
  selector: 'app-applied-candidates',
  templateUrl: './applied-candidates.component.html',
  styleUrls: ['./applied-candidates.component.scss']
})
export class AppliedCandidatesComponent implements OnInit {

  initSubscription: any;
  email: string = "";
  name: string = "";
  comapny_name: string = "";
  candidatesList: any = [];

  constructor(
    private jobsService: JobsService,
    private route: ActivatedRoute,
    private dialog: MatDialog,
    private interviewService: InterviewService,
  ) { }

  ngOnInit(): void {
    this.initSubscription = this.route.queryParams.subscribe((params: any) => {
      if (params) {
        console.log("params", params);
        this.email = params.email;
        this.name = params.name;
        this.comapny_name = params.company;
        this.getData();
      }
    });
  }

  getData() {
    this.jobsService.getAppliedCandidates(this.email, this.name).subscribe((res: any) => {
      if (res) {
        // this.candidatesList = res.filter((item: any) => item.status == "Applied");
        this.candidatesList = res.sort((a: any, b: any) => (a.status > b.status) ? 1 : ((b.status > a.status) ? -1 : 0))
        console.log("candidatesList", this.candidatesList);
      }
    });
  }

  reject(data: any) {
    if (window.confirm("Are you sure you want to reject ?")) {
      this.jobsService.rejectCandidate(data.id).subscribe((res: any) => {
        if (res) {
          this.getData();
          window.alert("Candidate rejected successfully");
        }
      });
    }
  }

  select(data: any) {
    const dialogRef = this.dialog.open(InterviewDialogComponent, {
      width: '30%',
      data: {
        jobseeker_name: data.jobseeker.name,
        comapny_name: this.comapny_name,
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
      if (result) {
        result['jobseeker_email'] = data.jobseeker.email;
        result['interview_time'] = result.hr + ':' + result.min;
        result['job_role'] = data.name;
        this.jobsService.selectCandidate(data.id).subscribe(res => {
          window.alert("Candidate selected successfully");
          this.getData();
        });
        this.interviewService.scheduleAnInterview(result).subscribe();
      }
    });
  }
}
