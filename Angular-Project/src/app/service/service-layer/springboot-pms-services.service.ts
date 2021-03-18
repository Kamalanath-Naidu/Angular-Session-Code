import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { EmpDetail } from '../../employee-list/employee-list.component';

export class SpringBootServicesMessage {

  constructor(public message:string) { }
}

@Injectable({
  providedIn: 'root'
})
export class SpringbootPmsServicesService {

  constructor(private http:HttpClient) { }

executeSpringBootService(){
  return this.http.get<SpringBootServicesMessage>('http://localhost:8080/springboot-service-module');
}

executeSpringBootServicetoGetEmployeeDetails(){
  return this.http.get<EmpDetail>('http://localhost:8080/springboot/employeelist');
}





}
