import { Injectable } from '@angular/core';
import {FamilyModel} from '../model/family-model';

@Injectable({
  providedIn: 'root'
})
export class FamilyService {

  private _familys: FamilyModel[];

  constructor() { }

  get familys(): FamilyModel[] {
    return this._familys;
  }

  set familys(value: FamilyModel[]) {
    this._familys = value;
  }

  set addFamily(value: FamilyModel) {
    this._familys = [
      value,
      ...this._familys
    ];
  }


  get emtyKid(): FamilyModel {
    const fm = new FamilyModel();
    fm.id = 1;
    fm.familyName = 'Turánszki';
    fm.kidid = [1];
    fm.userid = [1];
    return fm;
  }
}
