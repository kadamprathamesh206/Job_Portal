import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { AuthGuardService } from './services/auth-guard.service';
import { RouteGuardService } from './services/route-guard.service';
import { HttpClientModule } from '@angular/common/http';
import { CandidatesService } from './services/candidates.service';
import { CompaniesService } from './services/companies.service';
import { JobsService } from './services/jobs.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule
  ],
  providers: [
    AuthGuardService, 
    RouteGuardService,
    CandidatesService,
    CompaniesService,
    JobsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
