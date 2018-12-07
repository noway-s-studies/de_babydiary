import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {WishlistModel} from '../model/wishlist-model';
import {Observable} from 'rxjs';
import {UserService} from './user.service';

@Injectable({
  providedIn: 'root'
})
export class WishlistService {

  private _mail = '';
  private _pass = '';

  constructor(
    private _http: HttpClient,
    private _userService: UserService
  ) {
    this._mail = _userService.user.email;
    this. _pass = _userService.user.password;
  }

  getAll(): Observable<WishlistModel[]> {
    const url = '/wishlist/get/all';
    const headers = new HttpHeaders({
      'Authorization': 'Basic ' + btoa(this._mail + ':' + this._pass),
      'Content-Type': 'application/json'
    });
    return this._http.get<WishlistModel[]>(url, { headers: headers });
  }

  postNew(item: string, price: number): void {
    const url = '/wishlist/add';
    const body = JSON.stringify({item: item, price: price});
    const headers = new HttpHeaders({
      'Authorization': 'Basic ' + btoa(this._mail + ':' + this._pass),
      'Content-Type': 'application/json'
    });
    const req = this._http.post(url, body, { headers: headers })
      .subscribe(
        res => {
          console.log(res);
        },
        err => {
          console.log('Error occured');
        }
      );
  }

  get emtyWish(): WishlistModel {
    const wm = new WishlistModel();
    wm.id = null;
    wm.item = null;
    wm.price = null;
    return wm;
  }
}
