import {NgModule} from '@angular/core';
import {BsDropdownModule, CollapseModule, setTheme} from 'ngx-bootstrap';

@NgModule({
  imports: [
    CollapseModule.forRoot(),
    BsDropdownModule.forRoot()
  ]
})
export class AppBootstrapModule {
  constructor() {
    setTheme('bs3');
  }
}
