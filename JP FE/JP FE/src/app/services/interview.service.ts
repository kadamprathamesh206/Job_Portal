import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InterviewService {

  constructor(
    private http: HttpClient
  ) { }

  scheduleAnInterview(obj: any) {
    return this.http.post("http://localhost:8089/interviewInvetionj/newInvetion", obj);
  }

  getScheduledInterview(email: string) {
    return this.http.get("http://localhost:8089/interviewInvetionj/getnvetion/" + email);
  }

}
