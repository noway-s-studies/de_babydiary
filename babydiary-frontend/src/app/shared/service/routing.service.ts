import { Injectable } from '@angular/core';
import {AppRoutingModule} from '../../app-routing.module';

@Injectable({
  providedIn: 'root'
})
export class RoutingService {
  private static _appRoutingModule = new AppRoutingModule();

  constructor() {
  }

  static get appRoutingModule(): AppRoutingModule {
    return this._appRoutingModule;
  }
}
