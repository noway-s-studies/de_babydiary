import {Component} from '@angular/core';
import {UserService} from '../../../shared/service/user.service';
import {AlertComponent} from 'ngx-bootstrap/alert/alert.component';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  alerts: any[] = [];

  constructor(private _users: UserService,
              private _router: Router) {
    if (_users.isLoggedIn) {
      this._router.navigate(['/profile']);
    }
  }

  login(email: string, password: string) {
    if (this._users.logIn(email, password)) {
      this._router.navigate(['/profile'] );
    } else {
      this.alerts.push({
        type: 'danger',
        msg: `Helytelen belépési adatok!`,
        timeout: 5000
      });
    }
  }

  onClosed(dismissedAlert: AlertComponent): void {
    this.alerts = this.alerts.filter(alert => alert !== dismissedAlert);
  }
}
