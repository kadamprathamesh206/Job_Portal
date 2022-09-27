import { Component, OnInit } from '@angular/core';
import { CompaniesService } from 'src/app/services/companies.service';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.scss']
})
export class CompaniesComponent implements OnInit {

  companiesList: any = [];

  constructor(
    private companiesService: CompaniesService
  ) { }

  ngOnInit(): void {
    this.getData();
  }

  getData() {
    this.companiesService.getAllCompanies().subscribe((res: any) => {
      if (res) {
        this.companiesList = res;
      }
    });
  }

  delete(id: string) {
    if (window.confirm("Are you sure you want to delete ?")) {
      this.companiesService.deleteCompany(id).subscribe(res => {
        if (res) {
          this.getData();
        }
      });
    }
  }
}
