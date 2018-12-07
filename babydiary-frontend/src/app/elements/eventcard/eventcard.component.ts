import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {EventModel} from '../../shared/model/event-model';
import {ModalDirective} from 'ngx-bootstrap';
import {KidService} from '../../shared/service/kid.service';
import {KidModel} from '../../shared/model/kid-model';

@Component({
  selector: 'app-eventcard',
  templateUrl: './eventcard.component.html',
  styleUrls: ['./eventcard.component.scss']
})
export class EventcardComponent implements OnInit {

  @ViewChild('childModal') childModal: ModalDirective;
  @Input() esemeny: EventModel;
  private _kidModel: KidModel;

  constructor(
    private _kidService: KidService
  ) { }

  showChildModal(): void {
    this.childModal.show();
  }

  hideChildModal(): void {
    this.childModal.hide();
  }
  smallTitleText(esemeny: EventModel): string {
    return esemeny.title.length > 25 ? esemeny.title.substr(0, 25) + '...' : esemeny.title;
  }
  smallBodyText(esemeny: EventModel): string {
    return esemeny.bodyText.length > 100 ? esemeny.bodyText.substr(0, 100) + '...' : esemeny.bodyText;
  }
  get kinderPicture(): string {
    return this._kidModel ?
      this._kidModel.albums[0].link :
      './assets/temporary/pictures/kids/ed8bd06e-8034-4163-a9d5-7b589565c100.png';
  }

  ngOnInit(): void {
    this._kidService.getOne(this.esemeny.kinder).subscribe(data => {
      this._kidModel = data;
    });
  }
}
