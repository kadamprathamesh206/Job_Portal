import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CandidatesService } from 'src/app/services/candidates.service';
import { InterviewService } from 'src/app/services/interview.service';
import { JobsService } from 'src/app/services/jobs.service';
import { ViewInterviewDialogComponent } from './view-interview-dialog/view-interview-dialog.component';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.scss']
})
export class HistoryComponent implements OnInit {

  historyList: any = [];
  interviewList: any = [];

  constructor(
    private candidatesService: CandidatesService,
    private interviewService: InterviewService,
    private jobsService: JobsService,
    private dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    const user = JSON.parse(localStorage.getItem("user") || "");
    this.candidatesService.getHistory(user.id).subscribe((res: any) => {
      if (res) {

        this.jobsService.getAllJobs().subscribe((jobs: any) => {
          if (jobs) {
            this.historyList = [];

            res.forEach((element: any) => {
              const job = jobs.find((job: any) => job.name == element.name && job.requirements == element.requirements && job.experience == element.experience);
              if (job) {
                element['company_name'] = job.company.comapny_name;
                this.historyList.push(element);
              }
            });
            console.log("historyList", this.historyList);

          }
        });

      }
    });

    this.interviewService.getScheduledInterview(user.email).subscribe((res: any) => {
      if (res) {
        this.interviewList = res;
      }
    });
  }

  view(data: any) {
    console.log("view", data);
    const dialogRef = this.dialog.open(ViewInterviewDialogComponent, {
      width: '30%',
      data: { 
        company_name: data.company_name,
        interviewObj: this.interviewList.find((item: any) => 
        item.job_role === data.name && item.employper_name == data.company_name)
      }
    });

    // dialogRef.afterClosed().subscribe(result => {
    //   console.log('The dialog was closed', result);
    //   if (result) {
    //   }
    // });
  }
}
