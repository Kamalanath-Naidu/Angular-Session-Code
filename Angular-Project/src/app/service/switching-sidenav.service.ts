import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SwitchingSidenavService {

  hideSideNav: boolean = false;
 
  constructor() { }
 
  toggleSideNav(): void {
    console.log("Before click:"+this.hideSideNav);
    
    this.hideSideNav = !this.hideSideNav;
    console.log("After click:"+this.hideSideNav);
    
  }
}
