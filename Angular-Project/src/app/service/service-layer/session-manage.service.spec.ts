import { TestBed } from '@angular/core/testing';

import { SessionManageService } from './session-manage.service';

describe('SessionManageService', () => {
  let service: SessionManageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SessionManageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
