import { Component, OnInit } from '@angular/core';
import { CandidatesService } from 'src/app/services/candidates.service';

@Component({
  selector: 'app-candidates',
  templateUrl: './candidates.component.html',
  styleUrls: ['./candidates.component.scss']
})
export class CandidatesComponent implements OnInit {

  candidatesList: any = [];

  constructor(
    private candidatesService: CandidatesService
  ) { }

  ngOnInit(): void {
    this.getData();
  }

  getData() {
    this.candidatesService.getAllCandiates().subscribe((res: any) => {
      if (res) {
        this.candidatesList = res;
      }
    });
  }

  delete(id: string) {
    if (window.confirm("Are you sure you want to delete ?")) {
      this.candidatesService.deleteCandiate(id).subscribe(res => {
        if (res) {
          this.getData();
        }
      }); 
    }
  }
}
