import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminsService } from 'src/app/services/admins.service';
import { CandidatesService } from 'src/app/services/candidates.service';
import { CompaniesService } from 'src/app/services/companies.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  imgUrl = "https://saif.iitm.ac.in/saifimages/icon-login.png";

  loginForm = new FormGroup({
    type: new FormControl("1", [Validators.required]),
    email: new FormControl("", [Validators.required, Validators.pattern("[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[a-z]{2,3}")]),
    password: new FormControl("", [Validators.required]),
  });

  constructor(
    private router: Router,
    private adminsService: AdminsService,
    private candidatesService: CandidatesService,
    private companiesService: CompaniesService,
  ) { }

  ngOnInit(): void {
  }

  login() {
    const user = this.loginForm.getRawValue();
    localStorage.setItem("user", JSON.stringify(user));
    switch (user.type) {
      case "1":
        this.adminsService.signIn(user.email, user.password).subscribe((res: any) => {
          if (res) {
            let data: any = { ...res };
            data['type'] = user.type;
            localStorage.setItem("user", JSON.stringify(data));
            this.router.navigate(['/candidates']);
          }
        });
        break;

      case "2":
        this.candidatesService.signIn(user.email, user.password).subscribe((res: any) => {
          if (res) {
            let data: any = { ...res };
            data['type'] = user.type;
            localStorage.setItem("user", JSON.stringify(data));
            this.router.navigate(['/jobs']);
          }
        });
        break;

      default:
        this.companiesService.signIn(user.email, user.password).subscribe((res: any) => {
          if (res) {
            let data: any = { ...res };
            data['type'] = user.type;
            localStorage.setItem("user", JSON.stringify(data));
            this.router.navigate(['/jobs']);
          }
        });
        this.router.navigate(['/jobs']);
        break;
    }
  }
}
