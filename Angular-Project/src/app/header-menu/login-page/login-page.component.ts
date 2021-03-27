import { Component, OnInit } from '@angular/core';
import { Loginupdate as LoginResponse, ServiceStatus, SpringbootPmsServicesService } from './../../service/service-layer/springboot-pms-services.service';
import { Router } from '@angular/router';



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
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})

export class LoginPageComponent implements OnInit {

  constructor(private login: SpringbootPmsServicesService, private router: Router) { }
  public pass: UserDetails
  ngOnInit(): void {
    this.pass = new UserDetails(0, " ", " ", " ", " ", "", "");
  }

  passwordmismatch = false;
  emailidmismatch = false;
  passwordandemailmatch = false;
  passwordAndEmailMismatch: boolean;

  Logincheck() {
    console.log("hit success");
    this.login.executeLoginValidation(this.pass)
      .subscribe((data: ServiceStatus) => {
        this.passwordmismatch = false;
        this.emailidmismatch = false;
        this.passwordandemailmatch = false;
        this.passwordAndEmailMismatch = false;

        if (data.serviceStatus == "PASSCODE_AND_EMAIL_ID_MISMATCH") {
          this.passwordAndEmailMismatch = true;
          console.log('this.passwordAndEmailMismatch', this.passwordAndEmailMismatch);
        } else if (data.serviceStatus == "PASSCODE_MISMATCH_EMAIL_ID_MATCH") {
          this.passwordmismatch = true;
          console.log(this.passwordmismatch);
        } else if (data.serviceStatus == "PASSCODE_MATCH_EMAIL_ID_MISMATCH") {
          this.emailidmismatch = true;
          console.log(this.emailidmismatch);
        } else if (data.serviceStatus == "PASSCODE_AND_EMAIL_ID_MATCHES") {
          this.passwordandemailmatch = true;
          this.router.navigate(['home']);
          alert("logged in Successfully");
        }
      });
  }
}