import {Sex} from '../enum/sex.enum';

export class FunfactModel {
  id: number;
  week: string;
  text: string;
  music: string;
  skills: string;
  food: string;
  constructor(param?: FunfactModel) {
    if (param) {
      Object.assign(this, param);
    }
  }

  static get emtyFunfact(): FunfactModel {
    return {
      id: 1,
      week: '',
      text: '',
      music: '',
      skills: '',
      food: ''
    };
  }
}
