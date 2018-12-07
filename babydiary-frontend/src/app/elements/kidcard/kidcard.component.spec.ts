import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KidcardComponent } from './kidcard.component';

describe('KidcardComponent', () => {
  let component: KidcardComponent;
  let fixture: ComponentFixture<KidcardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KidcardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KidcardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
