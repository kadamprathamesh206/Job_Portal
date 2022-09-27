import { Routes } from "@angular/router";
import { AdminsComponent } from "./admins/admins.component";
import { AppliedCandidatesComponent } from "./applied-candidates/applied-candidates.component";
import { CandidatesComponent } from "./candidates/candidates.component";
import { CompaniesComponent } from "./companies/companies.component";
import { HistoryComponent } from "./history/history.component";
import { JobsComponent } from "./jobs/jobs.component";
import { LoginComponent } from "./login/login.component";
import { RegisterCompanyComponent } from "./register-company/register-company.component";
import { RegisterComponent } from "./register/register.component";

export const routes: Routes = [
    {
        path: "login",
        component: LoginComponent
    },
    {
        path: "register",
        component: RegisterComponent
    },
    {
        path: "registerCompany",
        component: RegisterCompanyComponent,
    },
    {
        path: "candidates",
        component: CandidatesComponent,
    },
    {
        path: "companies",
        component: CompaniesComponent,
    },
    {
        path: "jobs",
        component: JobsComponent,
    },
    {
        path: "history",
        component: HistoryComponent,
    },
    {
        path: "applied-candidates",
        component: AppliedCandidatesComponent,
    },
    {
        path: "admins",
        component: AdminsComponent,
    }
]