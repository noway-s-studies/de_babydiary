export class FamilyModel {

  private _id?: number;
  private _familyName: string;
  private _userid: number[];
  private _kidid: number[];

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get familyName(): string {
    return this._familyName;
  }

  set familyName(value: string) {
    this._familyName = value;
  }

  get userid(): number[] {
    return this._userid;
  }

  set userid(value: number[]) {
    this._userid = value;
  }

  get kidid(): number[] {
    return this._kidid;
  }

  set kidid(value: number[]) {
    this._kidid = value;
  }
}
