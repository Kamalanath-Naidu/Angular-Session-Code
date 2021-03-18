import { Component, OnInit } from '@angular/core';
import { EmployeeDetails } from './employee-details';
import { SpringbootPmsServicesService } from './../service/service-layer/springboot-pms-services.service'


export class EmpDetail{
  constructor(public plyid: number, public firstname:string, public lastname:string,public address1:string,public address2:string)  
  {}
}


@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

//empDetails:[]= EmpDetail[];
  messgaeFromSpringBootService:string;
   argName=" ";
   empdata:EmpDetail[];
   onscreenload=true;

  constructor(private service:SpringbootPmsServicesService) { }

  ngOnInit(): void {
    


  }

  getSpringBootServiceMessage(){
    this.service.executeSpringBootService().subscribe(//within this we get JSON data
      response=>{this.messgaeFromSpringBootService=response.message;} 
     // response =>this.SuccessResponse(response)
    )
  }//empDetails:[]= EmpDetail[];
  getEmployeeDetail(){
    this.service.executeSpringBootServicetoGetEmployeeDetails().subscribe(
      //response =>{this.empDetails = response;}
      data =>{this.successResponse(data);}
    )
  }

  /*SuccessResponse(response)
    {
      console.log(response.message);
      this.messgaeFromSpringBootService=response.message;
    }*/
    successResponse(data){
     this.empdata=data;
     console.log(this.empdata);
    }
  
 
 /*employeeList: EmployeeDetails [] = [

    new EmployeeDetails("Rajesh", " Kumar", "rajesh.kumar@gmailcom", "Address11111"),
    new EmployeeDetails("Rajesh", " Kumar", "rajesh.kumar@gmailcom", "Address11111"),
    new EmployeeDetails("Rajesh", " Kumar", "rajesh.kumar@gmailcom", "Address11111"),
    new EmployeeDetails("Rajesh", " Kumar", "rajesh.kumar@gmailcom", "Address11111"),
    new EmployeeDetails("Rajesh", " Kumar", "rajesh.kumar@gmailcom", "Address11111")

   ]*/


}
