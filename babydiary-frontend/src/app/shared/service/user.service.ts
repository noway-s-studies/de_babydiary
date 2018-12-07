import {UserModel} from '../model/user-model';
import {UserRole} from '../enum/user-role.enum';
import {Router} from '@angular/router';
import {Injectable} from '@angular/core';
import {Sex} from '../enum/sex.enum';
import {EventService} from './event.service';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import {throwError} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private _date: Date;
  private _user: UserModel;

  private _isLoggedIn = false;

  constructor(private _router: Router,
              private _evrntsService: EventService,
              private _http: HttpClient) {
    this._date = new Date();
  }

  logIn(email: string, password: string): boolean {
    if (email === 'admin@admin.hu' && password === 'asdf1234') {
      this._user = this.getUserExamples;
      this._user.userRole = UserRole.ADMIN;
      this._isLoggedIn = true;
      this._router.navigate(['/profile'] );
      return true;
    }
    const url = '/login';
    const body = JSON.stringify({username: '', password: ''});
    const headers = new HttpHeaders({'Authorization': 'Basic ' + btoa(email + ':' + password)});
    headers.append('Content-Type', 'application/json');
    this._http.post<UserModel>(url, body, { headers: headers })
      .pipe(
        catchError(this.handleError)
      )
      .subscribe(
        response => {
          this._user = this.getUserExamples;
          this._user.id = response.id;
          this._user.password = password;
          this._user.userRole = response.userRole;
          this._isLoggedIn = true;
          this._router.navigate(['/profile'] );
          return true;
        });
    return false;
  }

  get user(): UserModel {
    return this._user;
  }

  logOut() {
    delete(this._user);
    this._isLoggedIn = false;
    this._router.navigate(['/'] );
  }

  register(email: string, password: string, username?: string) {
    const nick = username ? username : 'Felhasználó';
    const url = '/register';
    const body = JSON.stringify({
      username: email,
      email: nick,
      password: password,
      userRole: 'PARENT'});
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    this._http.post<UserModel>(url, body, { headers: headers })
      .pipe(
        catchError(this.handleError)
      )
      .subscribe(
        response => {
          this._user = this.getUserExamples;
          this._user.id = response.id;
          this._user.email = response.username;
          this._user.userRole = response.userRole;
          console.log(this._user);
          this._isLoggedIn = true;
          this._router.navigate(['/profile'] );
        });
  }

  get isLoggedIn(): boolean {
    return this._isLoggedIn;
  }

  getAdminStatus(): boolean {
    return this.isLoggedIn ? this._user.userRole === UserRole.ADMIN : false;
  }

  get getUserExamples(): UserModel {
    const um = new UserModel();
    um.id = 1;
    um.email = '';
    um.password = '';
    um.username = '';
    um.userRole = UserRole.PARENT;
    um.firstName = '';
    um.lastName = '';
    um.sex = Sex.MALE;
    um.dateTime = new Date('2018-04-01T20:15');
    return um;
  }

  updateDb() {
    /**
     * Ide jön a módosított lokális adatok feltöltése az online adatbázisba.
     */
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  }
}
