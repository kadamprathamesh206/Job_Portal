import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CompaniesService } from 'src/app/services/companies.service';

@Component({
  selector: 'app-register-company',
  templateUrl: './register-company.component.html',
  styleUrls: ['./register-company.component.scss']
})
export class RegisterCompanyComponent implements OnInit {

  registrationForm = new FormGroup({
    id: new FormControl(""),
    comapny_name: new FormControl("", [Validators.required]),
    email: new FormControl("", [Validators.required, Validators.pattern("[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[a-z]{2,3}")]),
    password: new FormControl("", [Validators.required, Validators.minLength(2), Validators.maxLength(8)]),
    location: new FormControl("", [Validators.required]),
    no: new FormControl("", [Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
  });
  
  constructor(
    private router: Router,
    private companiesService: CompaniesService,
  ) { }

  ngOnInit(): void {
  }

  submit() {
    const user = this.registrationForm.getRawValue();
    console.log("submit", user);
    this.companiesService.addCompany(user).subscribe(res => {
      if (res) {
        window.alert("Company registered successfully");
        this.router.navigate(['/login']);
      }
    });
  }

}
