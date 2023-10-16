import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private zoekterm = new BehaviorSubject<any>(null);

  constructor() { }

  setZoekterm(zoekterm: string) {
    this.zoekterm.next(this.zoekterm)
    console.log('opslaan zoekterm' + zoekterm)
  }

  getZoekterm() {
    return this.zoekterm.asObservable();
  }
}
