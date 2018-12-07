import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-doc',
  templateUrl: './doc.component.html',
  styleUrls: ['./doc.component.scss']
})
export class DocComponent implements OnInit {

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
