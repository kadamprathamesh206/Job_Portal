import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminsService {

  constructor(
    private http: HttpClient
  ) { }

  signIn(email: string, password: string) {
    return this.http.post("http://localhost:8089/signIn", { email, password }).pipe(
      catchError((err: HttpErrorResponse) => {
        console.log("err in res", err);
        if (err.status === 400) {
          window.alert("Invalid Credentials")
        }
        return throwError(() => err);
      })
    );
  }

  getAllAdmins() {
    return this.http.get("http://localhost:8089/getAllAdmin");
  }

  deleteAdmin(id: string) {
    return this.http.delete("http://localhost:8089/delete/" + id);
  }

  addAdmin(obj: any) {
    return this.http.post("http://localhost:8089/register", obj).pipe(
      catchError((err: HttpErrorResponse) => {
        console.log("err in res", err);
        if (err.status === 400) {
          window.alert("Email Already Exists");
        }
        return throwError(() => err);
      })
    );
  }

  updateAdmin(id: string, obj: any) {
    return this.http.put("http://localhost:8089/updatedAdmin", obj);
  }
}
