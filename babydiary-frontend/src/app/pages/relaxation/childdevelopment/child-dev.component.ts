import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-chide',
  templateUrl: './child-dev.component.html',
  styleUrls: ['./child-dev.component.scss']
})
export class ChildDevComponent implements OnInit {

  time = false;

  constructor() { }

  ngOnInit() {
    this.setTimeout();
  }

  setTimeout() {
    setTimeout(
      () => {
        this.time = true;
      }, 5000
    );
  }
}
