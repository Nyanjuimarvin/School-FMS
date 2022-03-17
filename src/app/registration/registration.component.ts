import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  btnClick=() =>{
    this.router.navigate(['/Login']);
  };
  router: any;

  constructor() { }

  ngOnInit(): void {
  }

}
