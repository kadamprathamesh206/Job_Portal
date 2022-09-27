import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CandidatesService {

  constructor(
    private http: HttpClient
  ) { }

  signIn(email: string, password: string) {
    return this.http.post("http://localhost:8089/jobseeker/signin", { email, password }).pipe(
      catchError((err: HttpErrorResponse) => {
        console.log("err in res", err);
        if (err.status === 400) {
          window.alert("Invalid Credentials")
        }
        return throwError(() => err);
      })
    );
  }

  getAllCandiates() {
    return this.http.get("http://localhost:8089/jobseeker/getAllJobseeker");
  }

  deleteCandiate(id: string) {
    return this.http.delete("http://localhost:8089/jobseeker/deleteJobSeeker/" + id);
  }

  addCandiate(obj: any) {
    return this.http.post("http://localhost:8089/jobseeker/register", obj).pipe(
      catchError((err: HttpErrorResponse) => {
        console.log("err in res", err);
        if (err.status === 400) {
          window.alert("Email Already Exists");
        }
        return throwError(() => err);
      })
    );
  }

  getHistory(id: string) {
    return this.http.get("http://localhost:8089/statusPostJob/getAllStatusOfjob_seeker/" + id);
  }

  // updateCandiate(id: string, obj: any) {
  //   return this.http.put("http://localhost:8089/jobseeker/admin/updateCandiate/", obj);
  // }

}
