import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountantBursarformComponent } from './accountant-bursarform.component';

describe('AccountantBursarformComponent', () => {
  let component: AccountantBursarformComponent;
  let fixture: ComponentFixture<AccountantBursarformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AccountantBursarformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AccountantBursarformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
