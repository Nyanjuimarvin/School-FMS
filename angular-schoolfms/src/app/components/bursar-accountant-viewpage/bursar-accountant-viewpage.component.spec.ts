import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BursarAccountantViewpageComponent } from './bursar-accountant-viewpage.component';

describe('BursarAccountantViewpageComponent', () => {
  let component: BursarAccountantViewpageComponent;
  let fixture: ComponentFixture<BursarAccountantViewpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BursarAccountantViewpageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BursarAccountantViewpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
