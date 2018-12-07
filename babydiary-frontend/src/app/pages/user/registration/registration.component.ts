import {Component} from '@angular/core';
import {UserService} from '../../../shared/service/user.service';
import {AlertComponent} from 'ngx-bootstrap';
import {Location} from '@angular/common';
import {Router} from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent {
  alerts: any[] = [];
  constructor(private _userService: UserService,
              private _location: Location,
              private _router: Router) {
    if (_userService.isLoggedIn) {
      this._router.navigate(['/profile']);
    }}

  register(email: string,
           password: string,
           password2: string,
           nickname?: string) {
    if (!email || !password || password !== password2 ) {
      if (!email) {
        this.alerts.push({
          type: 'danger',
          msg: `Kérlek, add meg a belépéshez használt e-mail címed!`,
          timeout: 5000
        });
      }
      if (!password) {
        this.alerts.push({
          type: 'danger',
          msg: `Kérlek, add meg a jelszavad!`,
          timeout: 5000
        });
      }
      if (password !== password2) {
        this.alerts.push({
          type: 'danger',
          msg: `A "Jelszó" és a "Jelszó még egyszer" mezőbe megadott jelszavak nem egyeznek!`,
          timeout: 5000
        });
      }
    } else {
      this._userService.register(email, password, nickname);
    }
  }

  onClosed(dismissedAlert: AlertComponent): void {
    this.alerts = this.alerts.filter(alert => alert !== dismissedAlert);
  }

  backNavi() {
    this._location.back();
  }
}
