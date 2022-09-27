import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  isLoginPage = true;
  type: string = "";

  adminMenu: any = [
    { title: "Candidates", url: "/candidates" },
    { title: "Companies", url: "/companies" },
    { title: "Admins", url: "/admins" },
  ];

  candidateMenu: any = [
    { title: "Jobs", url: "/jobs" },
    { title: "History", url: "/history" },
  ];

  companyMenu: any = [
    { title: "Jobs", url: "/jobs" },
  ];

  mainMenu: any = [];

  constructor(private router: Router) { }

  ngAfterContentChecked() {
    if (localStorage.getItem("user")) {
      this.isLoginPage = false;
      this.type = JSON.parse(localStorage.getItem("user") || "").type;

      switch (this.type) {
        case "1":
          this.mainMenu = this.adminMenu;
          break;

        case "2":
          this.mainMenu = this.candidateMenu;
          break;

        default:
          this.mainMenu = this.companyMenu;
          break;
      }
    } else {
      this.isLoginPage = true;
      this.mainMenu = [];
    }
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['/home']);
    this.type = "";
  }
}
