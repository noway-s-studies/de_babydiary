import {Sex} from '../enum/sex.enum';
import {FunfactModel} from './funfact-model';
import {EventModel} from './event-model';
import {AlbumModel} from './album-model';

export class KidModel {

  private _id: number;
  private _birthday: string;
  private _firstName: string;
  private _lastName: string;
  private _sex: Sex;
  private _conception: string;
  private _height?: string;
  private _weight?: string;
  private _albums: AlbumModel[];

  get firstName(): string {
    return this._firstName;
  }

  set firstName(value: string) {
    this._firstName = value;
  }

  get lastName(): string {
    return this._lastName;
  }

  set lastName(value: string) {
    this._lastName = value;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get sex(): Sex {
    return this._sex;
  }

  set sex(value: Sex) {
    this._sex = value;
  }

  get height(): string {
    return this._height;
  }

  set height(value: string) {
    this._height = value;
  }

  get weight(): string {
    return this._weight;
  }

  set weight(value: string) {
    this._weight = value;
  }

  get albums(): AlbumModel[] {
    return this._albums;
  }

  set albums(value: AlbumModel[]) {
    this._albums = value;
  }

  get birthday(): string {
    return this._birthday;
  }

  set birthday(value: string) {
    this._birthday = value;
  }

  get conception(): string {
    return this._conception;
  }

  set conception(value: string) {
    this._conception = value;
  }

  constructor(param?: KidModel) {
    if (param) {
      Object.assign(this, param);
    }
  }
}
