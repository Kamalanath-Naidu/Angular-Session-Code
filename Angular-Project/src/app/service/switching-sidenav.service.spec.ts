import { TestBed } from '@angular/core/testing';

import { SwitchingSidenavService } from './switching-sidenav.service';

describe('SwitchingSidenavService', () => {
  let service: SwitchingSidenavService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SwitchingSidenavService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
