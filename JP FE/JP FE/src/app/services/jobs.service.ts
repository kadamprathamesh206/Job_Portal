import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JobsService {

  constructor(
    private http: HttpClient
  ) { }

  getAllJobs() {
    return this.http.get("http://localhost:8089/postJob/getAllpostJob");
  }

  addJob(obj: any) {
    return this.http.post("http://localhost:8089/postJob/createjob", obj);
  }

  applyJob(obj: any) {
    return this.http.post("http://localhost:8089/statusPostJob/appliedStatus", obj);
  }

  getJobsByCompany(email: string) {
    return this.http.get("http://localhost:8089/postJob/getJobforparticularcompany/" + email);
  }

  getJobsByCandidate(id: string) {
    return this.http.get("http://localhost:8089/statusPostJob/getAllStatusOfjob_seeker/" + id);
  }

  rejectCandidate(id: string) {
    return this.http.put("http://localhost:8089/statusPostJob/updateJobStatusRejected/", { id });
  }

  selectCandidate(id: string) {
    return this.http.put("http://localhost:8089/statusPostJob/updateJobStatusSelected/", { id });
  }

  getAppliedCandidates(email: string, name: string) {
    return this.http.post("http://localhost:8089/statusPostJob/getJobfrompostionAndEmail/", { email, name });
  }
}
