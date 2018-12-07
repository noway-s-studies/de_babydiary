import {Component, Input, OnInit} from '@angular/core';
import {KidModel} from '../../shared/model/kid-model';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Sex} from '../../shared/enum/sex.enum';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserService} from '../../shared/service/user.service';
import {AlbumModel} from '../../shared/model/album-model';

@Component({
  selector: 'app-kidcard',
  templateUrl: './kidcard.component.html',
  styleUrls: ['./kidcard.component.scss']
})
export class KidcardComponent implements OnInit {
  @Input() kid: KidModel;
  form: FormGroup;
  ronly = true;
  keys = Object.keys;
  sexEnum = Sex;
  private _mail = '';
  private _pass = '';


  constructor(private fb: FormBuilder,
              private _http: HttpClient,
              private _userService: UserService) {
    this._mail = _userService.user.email;
    this._pass = _userService.user.password;
  }

  onSubmit() {
    this.edit();
  }

  toDate(st: string) {
    console.log(new Date(st));
    return new Date();
  }

  edit(): void {
    this.ronly = this.ronly === false;
  }

  notMod(): void {
    this.edit();
    this.reloadKidData();
  }

  private reloadKidData() {
    this.form = this.fb.group(this.kid);
  }

  ngOnInit(): void {
    this.form = this.fb.group(
      {
        name: null,
        birthday: null,
        sex: null,
        height: null,
        weight: null,
        conception: null
      }
    );
  }

  kinderPicture(kid: KidModel): string {
    let pic = '';
    if (kid.albums[0] !== null) {
      pic = './assets/temporary/pictures/kids/ed8bd06e-8034-4163-a9d5-7b589565c100.png';
    } else {
      const url = '/album/get/' + kid.albums[0];
      const headers = new HttpHeaders({
        'Authorization': 'Basic ' + btoa(this._mail + ':' + this._pass),
        'Content-Type': 'application/json'
      });
      this._http.get<AlbumModel>(url, {headers: headers}).subscribe(data => {
        pic = data.link;
      },
          err => {
          console.log('Error occured');
        });
    }
    return pic;
  }
}
