import { TestBed } from '@angular/core/testing';

import { FetchDetailsService } from './fetch-details.service';

describe('FetchDetailsService', () => {
  let service: FetchDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FetchDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
