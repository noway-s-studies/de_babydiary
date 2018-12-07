export class AlbumModel {
  private _id: number;
  private _name: string;
  private _link: string;

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get link(): string {
    return this._link;
  }

  set link(value: string) {
    this._link = value;
  }

  constructor(param?: AlbumModel) {
    if (param) {
      Object.assign(this, param);
    }
  }
}
