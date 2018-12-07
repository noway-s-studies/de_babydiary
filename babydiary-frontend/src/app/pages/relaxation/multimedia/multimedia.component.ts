import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-multimedia',
  templateUrl: './multimedia.component.html',
  styleUrls: ['./multimedia.component.scss']
})
export class MultimediaComponent implements OnInit {

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
