import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompaniesService {

  constructor(
    private http: HttpClient
  ) { }

  signIn(email: string, password: string) {
    return this.http.post("http://localhost:8089/company/signIn", { email, password }).pipe(
      catchError((err: HttpErrorResponse) => {
        console.log("err in res", err);
        if (err.status === 400) {
          window.alert("Invalid Credentials")
        }
        return throwError(() => err);
      })
    );
  }

  getAllCompanies() {
    return this.http.get("http://localhost:8089/company/getAllCompanylist");
  }

  deleteCompany(id: string) {
    return this.http.delete("http://localhost:8089/company/deleteCompany/" + id);
  }

  addCompany(obj: any) {
    return this.http.post("http://localhost:8089/company/register", obj).pipe(
      catchError((err: HttpErrorResponse) => {
        console.log("err in res", err);
        if (err.status === 400) {
          window.alert("Email Already Exists");
        }
        return throwError(() => err);
      })
    );
  }

  updateCompany(id: string, obj: any) {
    return this.http.put("http://localhost:8089/company/admin/updateCompany/", obj);
  }
  
}

