import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CandidatesService } from 'src/app/services/candidates.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registrationForm = new FormGroup({
    id: new FormControl(""),
    name: new FormControl("", [Validators.required]),
    email: new FormControl("", [Validators.required, Validators.pattern("[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[a-z]{2,3}")]),
    password: new FormControl("", [Validators.required, Validators.minLength(2), Validators.maxLength(8)]),
    address: new FormControl("", [Validators.required]),
    education: new FormControl("", [Validators.required]),
    no: new FormControl("", [Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
  });
  
  constructor(
    private router: Router,
    private candidatesService: CandidatesService
  ) { }

  ngOnInit(): void {
  }

  submit() {
    const user = this.registrationForm.getRawValue();
    console.log("submit", user);
    this.candidatesService.addCandiate(user).subscribe(res => {
      if (res) {
        window.alert("Candidate registered successfully");
        this.router.navigate(['/login']);
      }
    });
  }
}
