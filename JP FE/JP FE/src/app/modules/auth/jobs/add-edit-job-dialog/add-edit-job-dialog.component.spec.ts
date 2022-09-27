import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditJobDialogComponent } from './add-edit-job-dialog.component';

describe('AddEditJobDialogComponent', () => {
  let component: AddEditJobDialogComponent;
  let fixture: ComponentFixture<AddEditJobDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEditJobDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditJobDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
