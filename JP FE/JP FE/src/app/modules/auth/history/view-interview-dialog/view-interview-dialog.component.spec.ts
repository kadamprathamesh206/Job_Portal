import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewInterviewDialogComponent } from './view-interview-dialog.component';

describe('ViewInterviewDialogComponent', () => {
  let component: ViewInterviewDialogComponent;
  let fixture: ComponentFixture<ViewInterviewDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewInterviewDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewInterviewDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
