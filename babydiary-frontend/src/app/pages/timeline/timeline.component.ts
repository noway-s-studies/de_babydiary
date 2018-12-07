import {Component, OnInit} from '@angular/core';
import {EventModel} from '../../shared/model/event-model';
import {EventService} from '../../shared/service/event.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.scss']
})
export class TimelineComponent implements OnInit {

  onlineEvents: EventModel[];
  newEventButtomText: string;
  idURL = this._route.snapshot.params['id'];

  constructor(private _route: ActivatedRoute,
              private _router: Router,
              private _eventService: EventService) {
    this.loadEvents();
  }

  loadEvents() {
    if (this.idURL) {
      this.newEventButtomText = 'Vissza';
    } else {
      this.newEventButtomText = 'Új esemény';
    }
  }

  bodyDivShow() {
    if (this.idURL) {
      this._router.navigate(['/timeline'] );
    } else {
      this._router.navigate(['/timeline/0/edit'] );
    }
  }

  ngOnInit(): void {
    this._eventService.getAllEventByFirebaseio().subscribe(data => {
      this.onlineEvents = data.sort((a: EventModel, b: EventModel) => {
        return new Date(b.dateTime).valueOf() - new Date(a.dateTime).valueOf();
      });
    });
  }
}
