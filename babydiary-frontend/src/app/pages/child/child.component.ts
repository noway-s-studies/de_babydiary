import { Component, OnInit } from '@angular/core';
import {KidModel} from '../../shared/model/kid-model';
import {KidService} from '../../shared/service/kid.service';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.scss']
})
export class ChildComponent implements OnInit {
  kinds: KidModel[];

  constructor(private _kidService: KidService) {
  }

  loadKids() {
    this._kidService.getAll().subscribe(data => {
      this.kinds = data;
    });
  }

  ngOnInit() {
    this.loadKids();
  }
}
