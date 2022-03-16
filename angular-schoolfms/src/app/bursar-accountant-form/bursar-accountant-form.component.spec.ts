import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BursarAccountantFormComponent } from './bursar-accountant-form.component';

describe('BursarAccountantFormComponent', () => {
  let component: BursarAccountantFormComponent;
  let fixture: ComponentFixture<BursarAccountantFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BursarAccountantFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BursarAccountantFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
