import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ServiceStatus, SpringbootPmsServicesService } from './../../service/service-layer/springboot-pms-services.service';

export class UserDetails {
  constructor(
    public user_id: number,
    public first_name: string,
    public lastname: string,
    public username: string,
    public email_id: string,
    public passcode: string,
    public cpasscode: string
  ) { }
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  user_details: UserDetails;
  //UserDetails: any;
  userNameExists = false;
  useremailidexists = false;
  username_useremailid_exists = false;

  constructor(private service: SpringbootPmsServicesService, private router: Router) { }

  ngOnInit(): void {
    this.user_details = new UserDetails(0, " ", " ", " ", " ", "", "");
  }
  passcodemismatch: boolean = false;
  saveuserDetail() {
    /*if(this.user_details.passcode!==this.user_details.cpasscode){
      console.log(this.passcodemismatch)
      this.passcodemismatch=true;
      console.log("Passcode mismatch")
    }
    else{
        }*/
    this.service.executeCreateUserDetails(this.user_details)
      .subscribe((data: ServiceStatus) => {
        this.userNameExists = false;
        this.useremailidexists = false;
        this.username_useremailid_exists = false;

        if (data.serviceStatus === "USER_NAME_AND_EMAIL_ID_ALREADY_EXISTS") {
          this.username_useremailid_exists = true;
        } else if (data.serviceStatus === "USER_NAME_EXISTS") {
          this.userNameExists = true;
        } else if (data.serviceStatus === "EMAIL_ID_EXISTS") {
          this.useremailidexists = true;
        } else if (data.serviceStatus === "USER_DETAILS_SAVED") {
          this.router.navigate(['login'])
        } else {
          console.log('server resp not identified');
          
        }
      }
      )
  }

}
