import {Injectable, OnInit} from '@angular/core';
import {EventModel} from '../model/event-model';
import {Router} from '@angular/router';
import {environment} from '../../environments/environment';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class EventService implements OnInit {

  private _events: EventModel[];

  constructor(private _router: Router,
              private _http: HttpClient) {
    this.sortEvents();
  }

  getAllEventByFirebaseio(): Observable<EventModel[]> {
    return this._http.get<EventModel[]>(`${environment.firebase.baseUrl}/event.json`)
      .pipe(
        map(data => Object.values(data))
      );
  }

  setEventByFirebaseio(event: EventModel): void {
    const body = JSON.stringify({
      id: event.id,
      kinder: +event.kinder,
      title: event.title,
      bodyText: event.bodyText,
      dateTime: event.dateTime.toString(),
    });
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const req = this._http.post(`${environment.firebase.baseUrl}/event.json`, body, { headers: headers })
      .subscribe(
        res => {
          console.log(res);
        },
        err => {
          console.log('Error occured');
        }
      );
  }

  sortEvents(): void {
    if (this._events != null) {
      this._events = this._events.sort((a: EventModel, b: EventModel) => {
        return b.dateTime.valueOf() - a.dateTime.valueOf();
      });
    }
  }

  eventById(id: number): EventModel {
    const event = this._events.filter(u => u.id === id);
    return event.length > 0 ? event[0] : this.emtyEvent;
  }

  get events(): EventModel[] {
    return this._events;
  }

  set event(value: EventModel) {
    this._events = [
      value,
      ...this._events
    ].sort((a: EventModel, b: EventModel) => {
      return b.dateTime.valueOf() - a.dateTime.valueOf();
    });
    this.setEventByFirebaseio(value);
  }

  addEventByTag(id: number,
                kinder: number,
                title: string,
                bodyText: string,
                dateTime: Date) {
    const em = new EventModel();
    em.id = id;
    em.kinder = kinder;
    em.title = title;
    em.bodyText = bodyText;
    em.dateTime = new Date(dateTime);
    this.setEventByFirebaseio(em);
    this._events = [
      em,
      ...this._events
    ].sort((a: EventModel, b: EventModel) => {
      return b.dateTime.valueOf() - a.dateTime.valueOf();
    });
  }

  setEventByTag(id: number,
                kinder: number,
                title: string,
                bodyText: string,
                dateTime: Date) {
    const em = new EventModel();
    em.id = id;
    // em.kinder = this._kidService.getOne(kinder);
    em.title = title;
    em.bodyText = bodyText;
    em.dateTime = new Date(dateTime);
    const eventAll = this._events.filter(u => u.id !== em.id);
    this._events = [
      em,
      ...eventAll
    ].sort((a: EventModel, b: EventModel) => {
      return b.dateTime.valueOf() - a.dateTime.valueOf();
    });
  }

  set modEvent(value: EventModel) {
    const eventAll = this._events.filter(u => u.id !== value.id);
    this._events = [
      value,
      ...eventAll
    ].sort((a: EventModel, b: EventModel) => {
      return b.dateTime.valueOf() - a.dateTime.valueOf();
    });
  }

  get emtyEvent(): EventModel {
    const em = new EventModel();
    em.id = 1;
    em.kinder = null;
    em.title = null;
    em.bodyText = null;
    em.dateTime = new Date();
    return em;
  }

  loginEvent(): void {
    const em = new EventModel();
    em.id = 1;
    // em.kinder = this._kidService.emtyKid;
    em.title = 'Utoljára belépett';
    em.bodyText = '';
    em.dateTime = new Date();
    this._events = [em];
  }

  get maxEventId(): number {
    if (this._events) {
      return  this._events.reduce((x, y) => x.id > y.id ? x : y).id;
    } else {
      return  1;
    }
  }

  ngOnInit(): void {
  }
}
