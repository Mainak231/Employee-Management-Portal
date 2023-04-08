import { TestBed } from '@angular/core/testing';

import { CanActivateRouteGuardService } from './can-activate-route-guard.service';

describe('CanActivateRouteGuardService', () => {
  let service: CanActivateRouteGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CanActivateRouteGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
