import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GebruikerComponent } from './gebruiker.component';

describe('GebruikerComponent', () => {
  let component: GebruikerComponent;
  let fixture: ComponentFixture<GebruikerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GebruikerComponent]
    });
    fixture = TestBed.createComponent(GebruikerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
