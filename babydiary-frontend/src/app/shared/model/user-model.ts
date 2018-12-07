import {Sex} from '../enum/sex.enum';
import {UserRole} from '../enum/user-role.enum';

export class UserModel {
  private _id: number;
  private _username: string;
  private _email: string;
  private _password?: string;
  private _userRole: UserRole;
  private _firstName?: string;
  private _lastName?: string;
  private _sex?: Sex;
  private _dateTime: Date;


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get username(): string {
    return this._username;
  }

  set username(value: string) {
    this._username = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get userRole(): UserRole {
    return this._userRole;
  }

  set userRole(value: UserRole) {
    this._userRole = value;
  }

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

  get sex(): Sex {
    return this._sex;
  }

  set sex(value: Sex) {
    this._sex = value;
  }

  get dateTime(): Date {
    return this._dateTime;
  }

  set dateTime(value: Date) {
    this._dateTime = value;
  }

  constructor(param?: UserModel) {
    if (param) {
      Object.assign(this, param);
    }
  }
}
