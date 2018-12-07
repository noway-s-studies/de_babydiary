import {Component, OnInit} from '@angular/core';
import {EventService} from '../../shared/service/event.service';
import {AlertComponent} from 'ngx-bootstrap';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {KidService} from '../../shared/service/kid.service';
import {KidModel} from '../../shared/model/kid-model';
import {EventModel} from '../../shared/model/event-model';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-timeline-post',
  templateUrl: './eventcard-post.component.html',
  styleUrls: ['./eventcard-post.component.scss']
})
export class EventcardPostComponent implements OnInit {

  idURL = this._route.snapshot.params['id'];
  alerts: any[] = [];
  private _actualEvent: EventModel;
  kids$: Observable<KidModel[]>;
  maxEventId = 0;

  constructor(private _route: ActivatedRoute,
              private _router: Router,
              private _eventService: EventService,
              private _kidService: KidService) {
  }

  get actualEvent(): EventModel {
    return this._actualEvent;
  }

  set actualEvent(value: EventModel) {
    this._actualEvent = value;
  }

  inputDateFormat(em: EventModel): string {
    return em.dateTime.getFullYear().toString() + '-'
      + addZero(em.dateTime.getMonth() + 1).toString() + '-'
      + addZero(em.dateTime.getDate()).toString() + 'T'
      + addZero(em.dateTime.getHours()).toString() + ':'
      + addZero(em.dateTime.getMinutes()).toString();
  }

  selectKidId(em: EventModel): number {
    return em.kinder;
  }

  onSubmit(form, id: number) {
    if (!form.id || !form.title || !form.bodyText || !form.dateTime) {
      if (form.id === 'Válassz...') {
        this.alerts.push({
          type: 'danger',
          msg: `Kérlek, válaszd ki a gyermeket!`,
          timeout: 5000
        });
      }
      if (!form.title) {
        this.alerts.push({
          type: 'danger',
          msg: `Kérlek, add meg az esemény címét!`,
          timeout: 5000
        });
      }
      if (!form.bodyText) {
        this.alerts.push({
          type: 'danger',
          msg: `Kérlek, add meg az esemény részletes leírását!`,
          timeout: 5000
        });
      }
      if (!form.dateTime) {
        this.alerts.push({
          type: 'danger',
          msg: `Kérlek, add meg az esemény időpontját!`,
          timeout: 5000
        });
      }
    } else {
      if (this.idURL === '0') {
        this._eventService.getAllEventByFirebaseio().subscribe(data => {
          for (const ae of data) {
            if (ae.id > this.maxEventId) {
              this.maxEventId = ae.id;
            }
          }
          this._eventService.addEventByTag(++this.maxEventId, form.id, form.title, form.bodyText, form.dateTime);
        });
      } else {
        // this._eventService.setEventByTag(+this.idURL, form.id, form.title, form.bodyText, form.dateTime);
      }
      this._router.navigate(['/timeline'] );
    }
  }

  onClosed(dismissedAlert: AlertComponent): void {
    this.alerts = this.alerts.filter(alert => alert !== dismissedAlert);
  }

  ngOnInit(): void {
    const handle404 = () => {
      this._router.navigate(['404']);
    };
    this._route.paramMap.subscribe(
      (params: ParamMap) => {
        if (params === null) {
          handle404();
        } else {
          this.idURL = params.get('id');
        }
      }, err => {
        return handle404();
      }
    );
    if (this.idURL === '0') {
      this.actualEvent = this._eventService.emtyEvent;
    } else {
      this._eventService.getAllEventByFirebaseio().subscribe(data => {
        for (const ae of data) {
          if (ae.id === +this.idURL) {
            this.actualEvent = ae;
            this.actualEvent.dateTime = new Date(ae.dateTime);
          }
        }
      });
    }
    this.kids$ = this._kidService.getAll();
  }
}

function addZero(i) {
  if (i < 10) {
    i = '0' + i;
  }
  return i;
}
