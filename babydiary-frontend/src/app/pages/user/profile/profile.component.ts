import {Component} from '@angular/core';
import {UserService} from '../../../shared/service/user.service';
import {UserRole} from '../../../shared/enum/user-role.enum';
import {Sex} from '../../../shared/enum/sex.enum';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent {
  sexEnum = Sex;
  userRoleKey = UserRole;

  constructor(private _userService: UserService) { }

  get userService(): UserService {
    return this._userService;
  }

  onSubmit(form) {
    console.log('mod');
    this._userService.updateDb();
  }
}
