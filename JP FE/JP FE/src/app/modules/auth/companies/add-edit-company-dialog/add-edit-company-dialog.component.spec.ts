import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditCompanyDialogComponent } from './add-edit-company-dialog.component';

describe('AddEditCompanyDialogComponent', () => {
  let component: AddEditCompanyDialogComponent;
  let fixture: ComponentFixture<AddEditCompanyDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEditCompanyDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditCompanyDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
