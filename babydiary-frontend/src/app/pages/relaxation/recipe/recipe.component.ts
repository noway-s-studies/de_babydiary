import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.scss']
})
export class RecipeComponent implements OnInit {

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
