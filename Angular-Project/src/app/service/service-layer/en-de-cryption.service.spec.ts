import { TestBed } from '@angular/core/testing';

import { EnDeCryptionService } from './en-de-cryption.service';

describe('EnDeCryptionService', () => {
  let service: EnDeCryptionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EnDeCryptionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
