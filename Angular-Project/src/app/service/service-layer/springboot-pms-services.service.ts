import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { EmpDetail } from '../../employee-list/employee-list.component';

// export class SpringBootServicesMessage {

//   constructor(public message: string) { }
// }

export class ServiceStatus {
  constructor(public serviceStatus: string) { }
}

export class Loginupdate {
  constructor(public login: string) { }
}

@Injectable({
  providedIn: 'root'
})
export class SpringbootPmsServicesService {

  private HOST_NAME = 'http://localhost:8080';
  private APP_NAME = 'springboot';
  public APP_SERVICE_URL = this.getServiceURL();

  constructor(private http: HttpClient) { }

  private getServiceURL() {
    return `${this.HOST_NAME}/${this.APP_NAME}`;
    // return this.HOST_NAME + '/' + this.APP_NAME;
  }

  executeSpringBootService() {
    return this.http.get(this.APP_SERVICE_URL + '/service', { responseType: 'test' as 'json' });
  }

  executeSpringBootServicetoGetEmployeeDetails() {
    return this.http.get<EmpDetail>(this.APP_SERVICE_URL + '/employeelist');
  }

  executeCreateUserDetails(UserDetail) {
    return this.http.post<ServiceStatus>(this.APP_SERVICE_URL+'/createUserDetails', UserDetail);
  }

  executeLoginValidation(LoginDetail) {
    return this.http.post<ServiceStatus>(this.APP_SERVICE_URL + '/authenticateUser', LoginDetail);

  }
}
