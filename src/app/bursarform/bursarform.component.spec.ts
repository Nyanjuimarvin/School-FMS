import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BursarformComponent } from './bursarform.component';

describe('BursarformComponent', () => {
  let component: BursarformComponent;
  let fixture: ComponentFixture<BursarformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BursarformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BursarformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
