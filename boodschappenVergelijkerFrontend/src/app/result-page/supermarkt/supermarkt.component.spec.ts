import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SupermarktComponent } from './supermarkt.component';

describe('SupermarktComponent', () => {
  let component: SupermarktComponent;
  let fixture: ComponentFixture<SupermarktComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SupermarktComponent]
    });
    fixture = TestBed.createComponent(SupermarktComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
