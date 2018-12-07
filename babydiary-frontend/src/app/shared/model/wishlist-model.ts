export class WishlistModel {
  private _id: number;
  private _item: string;
  private _price: number;

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get item(): string {
    return this._item;
  }

  set item(value: string) {
    this._item = value;
  }

  get price(): number {
    return this._price;
  }

  set price(value: number) {
    this._price = value;
  }

  constructor(param?: WishlistModel) {
    if (param) {
      Object.assign(this, param);
    }
  }
}
