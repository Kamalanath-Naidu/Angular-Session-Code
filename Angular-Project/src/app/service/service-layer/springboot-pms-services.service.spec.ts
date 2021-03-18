import { TestBed } from '@angular/core/testing';

import { SpringbootPmsServicesService } from './springboot-pms-services.service';

describe('SpringbootPmsServicesService', () => {
  let service: SpringbootPmsServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SpringbootPmsServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
