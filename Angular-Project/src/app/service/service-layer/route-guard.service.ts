import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';
import {SessionManageService} from './../../service/service-layer/session-manage.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService {

  constructor(public sessionService: SessionManageService,public router:Router ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){

    if(this.sessionService.isUserLoggedIn()){
      return true;
    }
    else{
      this.router.navigate(['head/login']);
      return false;
    }
  }
}
