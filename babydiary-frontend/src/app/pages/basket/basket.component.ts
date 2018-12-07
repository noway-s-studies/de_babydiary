import { Component, OnInit } from '@angular/core';
import {WishlistModel} from '../../shared/model/wishlist-model';
import {WishlistService} from '../../shared/service/wishlist.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.scss']
})
export class BasketComponent implements OnInit {

  newBasket: WishlistModel;
  baskets: WishlistModel[];
  private _lastRandom = 0;

  constructor(
    private _router: Router,
    private _basketService: WishlistService) {
  }

  ngOnInit() {
    this._basketService.getAll().subscribe(data => {
      this.baskets = data;
    });
    this.newBasket = this._basketService.emtyWish;
  }

  onSubmit(form) {
    if (form.item.length > 0 && +form.price > 0) {
      this.newBasket.item = form.item;
      this.newBasket.price = +form.price;
      this._basketService.postNew(this.newBasket.item, this.newBasket.price);
      this.newBasket = this._basketService.emtyWish;
    }
    this._basketService.getAll().subscribe(data => {
      this.baskets = data;
    });
  }

  calculateStyles(num: number): string {
    if (num < 10) {
      return 'list-group-item bg-primary';
    } else if (num < 100) {
      return 'list-group-item bg-secondary';
    } else if (num < 1000) {
      return 'list-group-item bg-success';
    } else if (num < 10000) {
      return 'list-group-item bg-warning';
    } else if (num < 100000) {
      return 'list-group-item bg-warning';
    } else if (num < 1000000) {
      return 'list-group-item bg-info';
    } else {
      return 'list-group-item bg-dark';
    }
  }


  randomNum(): number {
    let n = this._lastRandom;
    while ( n === this._lastRandom ) {
      n = Math.floor(Math.random() * (7 - 1)) + 1;
    }
    this._lastRandom = n;
    console.log(n);
    return n;
  }
}
