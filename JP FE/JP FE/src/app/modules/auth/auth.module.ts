import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { routes } from './auth.routing';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/material.module';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RegisterCompanyComponent } from './register-company/register-company.component';
import { CandidatesComponent } from './candidates/candidates.component';
import { CompaniesComponent } from './companies/companies.component';
import { JobsComponent } from './jobs/jobs.component';
import { HistoryComponent } from './history/history.component';
import { AppliedCandidatesComponent } from './applied-candidates/applied-candidates.component';
import { AddEditCandidateDialogComponent } from './candidates/add-edit-candidate-dialog/add-edit-candidate-dialog.component';
import { AddEditCompanyDialogComponent } from './companies/add-edit-company-dialog/add-edit-company-dialog.component';
import { AddEditJobDialogComponent } from './jobs/add-edit-job-dialog/add-edit-job-dialog.component';
import { AdminsComponent } from './admins/admins.component';
import { AddEditAdminComponent } from './admins/add-edit-admin/add-edit-admin.component';
import { InterviewDialogComponent } from './applied-candidates/interview-dialog/interview-dialog.component';
import { ViewInterviewDialogComponent } from './history/view-interview-dialog/view-interview-dialog.component';

@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    RegisterCompanyComponent,
    CandidatesComponent,
    CompaniesComponent,
    JobsComponent,
    HistoryComponent,
    AppliedCandidatesComponent,
    AddEditCandidateDialogComponent,
    AddEditCompanyDialogComponent,
    AddEditJobDialogComponent,
    AdminsComponent,
    AddEditAdminComponent,
    InterviewDialogComponent,
    ViewInterviewDialogComponent,
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    FormsModule,
    ReactiveFormsModule,
    MaterialModule
  ]
})
export class AuthModule { }
