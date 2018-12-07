import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './pages/user/login/login.component';
import {TimelineComponent} from './pages/timeline/timeline.component';
import {ProfileComponent} from './pages/user/profile/profile.component';
import {PageNotFoundComponent} from './pages/page-not-found/page-not-found.component';
import {RegistrationComponent} from './pages/user/registration/registration.component';
import {ChildComponent} from './pages/child/child.component';
import {BasketComponent} from './pages/basket/basket.component';
import {AdminComponent} from './pages/user/admin/admin.component';
import {MultimediaComponent} from './pages/relaxation/multimedia/multimedia.component';
import {RecipeComponent} from './pages/relaxation/recipe/recipe.component';
import {DocComponent} from './pages/relaxation/doc/doc.component';
import {ChildDevComponent} from './pages/relaxation/childdevelopment/child-dev.component';
import {AboutsComponent} from './pages/aboutus/abouts.component';
import {LoggedInGuard} from './shared/logged-in.guard';
import {EventcardPostComponent} from './elements/eventcard-post/eventcard-post.component';

const routes: Routes = [
  { path: '', redirectTo: '/lg', pathMatch: 'full' },
  { path: 'lg', component: LoginComponent },
  { path: 'profile', component: ProfileComponent, canActivate: [LoggedInGuard] },
  { path: 'rg', component: RegistrationComponent },
  { path: 'ch', component: ChildComponent, canActivate: [LoggedInGuard]},
  { path: 'timeline',
    children: [
      {path: '', component: TimelineComponent, canActivate: [LoggedInGuard]},
      {path: ':id', component: EventcardPostComponent, canActivate: [LoggedInGuard]},
      {path: ':id/edit', component: EventcardPostComponent, canActivate: [LoggedInGuard]},
      ]
  },
  { path: 'basket', component: BasketComponent, canActivate: [LoggedInGuard] },
  { path: 'admin', component: AdminComponent, canActivate: [LoggedInGuard] },
  { path: 'multimedia', component: MultimediaComponent, canActivate: [LoggedInGuard] },
  { path: 'recipe', component: RecipeComponent, canActivate: [LoggedInGuard] },
  { path: 'doc', component: DocComponent, canActivate: [LoggedInGuard] },
  { path: 'ch', component: ChildDevComponent, canActivate: [LoggedInGuard] },
  { path: 'abouts', component: AboutsComponent },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {
  private _timeline = 'timeline';
  private _timelineLink = '/' + this._timeline;
  private _index = 'lg';
  private _indexLink = '/' + this._index;
  private _login = 'lg';
  private _loginLink = '/' + this._login;
  private _loginNextLink = this._timelineLink;
  private _logout = this._login;
  private _logoutLink = '/' + this._logout;
  private _profile = 'profile';
  private _profileLink = '/' + this._profile;
  private _registration = 'rg';
  private _registrationLink = '/' + this._registration;
  private _registrationNext = this._profileLink;
  private _child = 'ch';
  private _childLink = '/' + this._child;
  private _basket = 'basket';
  private _basketLink = '/' + this._basket;
  private _admin = 'admin';
  private _adminLink = '/' + this._admin;
  private _multimedia = 'multimedia';
  private _multimediaLink = '/' + this._multimedia;
  private _recipe = 'recipe';
  private _recipeLink = '/' + this._recipe;
  private _doc = 'doc';
  private _docLink = '/' + this._doc;
  private _chide = 'chide';
  private _childdevelopmentLink = '/' + this._chide;
  private _aboutus = 'abouts';
  private _aboutusLink = '/' + this._aboutus;

  get index(): string {
    return this._index;
  }

  get indexLink(): string {
    return this._indexLink;
  }

  get login(): string {
    return this._login;
  }

  get loginLink(): string {
    return this._loginLink;
  }

  get profile(): string {
    return this._profile;
  }

  get profileLink(): string {
    return this._profileLink;
  }

  get registration(): string {
    return this._registration;
  }

  get registrationLink(): string {
    return this._registrationLink;
  }

  get child(): string {
    return this._child;
  }

  get childLink(): string {
    return this._childLink;
  }

  get timeline(): string {
    return this._timeline;
  }

  get timelineLink(): string {
    return this._timelineLink;
  }

  get basket(): string {
    return this._basket;
  }

  get basketLink(): string {
    return this._basketLink;
  }

  get admin(): string {
    return this._admin;
  }

  get adminLink(): string {
    return this._adminLink;
  }

  get multimedia(): string {
    return this._multimedia;
  }

  get multimediaLink(): string {
    return this._multimediaLink;
  }

  get recipe(): string {
    return this._recipe;
  }

  get recipeLink(): string {
    return this._recipeLink;
  }

  get doc(): string {
    return this._doc;
  }

  get docLink(): string {
    return this._docLink;
  }

  get chide(): string {
    return this._chide;
  }

  get childdevelopmentLink(): string {
    return this._childdevelopmentLink;
  }

  get aboutus(): string {
    return this._aboutus;
  }

  get aboutusLink(): string {
    return this._aboutusLink;
  }


  get loginNextLink(): string {
    return this._loginNextLink;
  }

  get logout(): string {
    return this._logout;
  }

  get logoutLink(): string {
    return this._logoutLink;
  }

  get registrationNext(): string {
    return this._registrationNext;
  }
}
