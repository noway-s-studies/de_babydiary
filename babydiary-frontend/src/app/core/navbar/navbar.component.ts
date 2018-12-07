import {Component, OnInit} from '@angular/core';
import {UserService} from '../../shared/service/user.service';
import {RoutingService} from '../../shared/service/routing.service';

@Component({
  selector: 'app-nav',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  isCollapsedMasterMenu = true;
  isCollapsedMasterSec = 0;
  routing = RoutingService.appRoutingModule;
  foundKid = true;

  constructor(private userService: UserService) {
  }

  logOut() {
    this.userService.logOut();
  }

  logInStatus(): boolean {
    return this.userService.isLoggedIn;
  }

  getAdminStatus(): boolean {
    return this.userService.getAdminStatus();
  }

  ngOnInit(): void {
  }
}
