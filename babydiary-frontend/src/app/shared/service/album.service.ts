import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserService} from './user.service';
import {Observable} from 'rxjs';
import {AlbumModel} from '../model/album-model';

@Injectable({
  providedIn: 'root'
})
export class AlbumService implements OnInit {

  constructor(
    private _http: HttpClient,
    private _userService: UserService
  ) {
  }

  ngOnInit(): void {
  }

  getAll(): Observable<AlbumModel[]> {
    const url = '/album/get/all';
    const headers = new HttpHeaders({
      'Authorization': 'Basic ' + btoa(this._userService.user.email + ':' + this._userService.user.password),
      'Content-Type': 'application/json'
    });
    return this._http.get<AlbumModel[]>(url, { headers: headers });
  }

  getOne(actId: number): Observable<AlbumModel> {
    const url = '/album/get/' + actId;
    const headers = new HttpHeaders({
      'Authorization': 'Basic ' + btoa(this._userService.user.email + ':' + this._userService.user.password),
      'Content-Type': 'application/json'
    });
    return this._http.get<AlbumModel>(url, { headers: headers });
  }

  postNew(name: string, link: number): number {
    const url = '/album/add';
    const body = JSON.stringify({item: name, price: link});
    const headers = new HttpHeaders({
      'Authorization': 'Basic ' + btoa(this._userService.user.email + ':' + this._userService.user.password),
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
    let actId: number;
    let albums: AlbumModel[];
    this.getAll().subscribe(data => {
      albums = data;
    });
    for (const ab of albums) {
      if (ab.name = name && ab.link) {
        actId = ab.id;
      }
    }
    return actId;
  }

  get emtyAlbum(): AlbumModel {
    const am = new AlbumModel();
    am.id = null;
    am.name = null;
    am.link = 'https://is3-ssl.mzstatic.com/image/thumb/Purple122/v4/55/98/d7/5598d778-6d8d-2c1c-1b33-fa047e500d5d/source/256x256bb.jpg';
    return am;
  }
}
