import {Injectable, OnInit} from '@angular/core';
import {KidModel} from '../model/kid-model';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Sex} from '../enum/sex.enum';
import {AlbumService} from './album.service';
import {UserService} from './user.service';

@Injectable({
  providedIn: 'root'
})
export class KidService implements OnInit {
  private _date: Date;

  private _kids: KidModel[];

  constructor(
    private _http: HttpClient,
    private _albumService: AlbumService,
    private _userService: UserService
  ) {
    this._date = new Date();
  }

  ngOnInit(): void {
  }

  get kids(): KidModel[] {
    return this._kids;
  }

  set kids(value: KidModel[]) {
    this._kids = value;
  }

  getAll(): Observable<KidModel[]> {
    const url = '/child/get/all';
    const headers = new HttpHeaders({
      'Authorization': 'Basic ' + btoa(this._userService.user.email + ':' + this._userService.user.password),
      'Content-Type': 'application/json'
    });
    return this._http.get<KidModel[]>(url, { headers: headers });
  }

  getOne(actId: number): Observable<KidModel> {
    const url = '/child/get/' + actId;
    const headers = new HttpHeaders({
      'Authorization': 'Basic ' + btoa(this._userService.user.email + ':' + this._userService.user.password),
      'Content-Type': 'application/json'
    });
    return this._http.get<KidModel>(url, { headers: headers });
  }

  postNew(
    firstName: string,
    lastName: string,
    albums: number[],
    sex: Sex,
    height: string,
    weight: string,
    birthday: Date,
    conception: Date
  ): number {
    const url = '/child/add';
    const body = JSON.stringify({
      firstName: firstName,
      lastName: lastName,
      albumIds: albums,
      sex: sex,
      birthday: birthday,
      conception: conception
    });
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
    let kids: KidModel[];
    this.getAll().subscribe(data => {
      kids = data;
    });
    for (const ab of kids) {
      if (ab.firstName = name && ab.lastName) {
        actId = ab.id;
      }
    }
    return actId;
  }

  get emtyKid(): KidModel {
    const km = new KidModel();
    const dt = new Date();
    km.id = 1;
    km.birthday = '';
    km.firstName = '';
    km.lastName = '';
    km.sex = Sex.MALE;
    km.height = '';
    km.weight = '';
    km.conception = '';
    km.albums = [this._albumService.emtyAlbum];
    return km;
  }
}
