import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditCandidateDialogComponent } from './add-edit-candidate-dialog.component';

describe('AddEditCandidateDialogComponent', () => {
  let component: AddEditCandidateDialogComponent;
  let fixture: ComponentFixture<AddEditCandidateDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEditCandidateDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditCandidateDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
