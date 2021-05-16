import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeAdditionComponent } from './employee-addition.component';

describe('EmployeeAdditionComponent', () => {
  let component: EmployeeAdditionComponent;
  let fixture: ComponentFixture<EmployeeAdditionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeAdditionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeAdditionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
