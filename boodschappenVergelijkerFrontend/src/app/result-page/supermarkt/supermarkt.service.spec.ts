import { TestBed } from '@angular/core/testing';

import { SupermarktService } from './supermarkt.service';

describe('SupermarktService', () => {
  let service: SupermarktService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SupermarktService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
