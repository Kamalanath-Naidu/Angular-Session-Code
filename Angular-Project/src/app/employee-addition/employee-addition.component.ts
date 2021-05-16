import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators,FormBuilder } from '@angular/forms';
import { ServiceStatus,SpringbootPmsServicesService } from './../service/service-layer/springboot-pms-services.service';

export class Profile{
  constructor(
    public  profile_id:number,
    public  first_name : String,
    public  last_name: string,
    public  dob: string,
    public  nuemail_id: string,
    public  address1: string,
    public  address2: string,
    public  city: string,
    public  state: string,
    public  zip: string,
    public  phone: string,
    public  gender: string,
    public  undergrade: string,
    public  postgrade: string,
    public  certfication: string,
    public  techeng: string,
    public  exp: string,    
    public  preproject:string,
    public  users: number
  ){}
}

@Component({
  selector: 'app-employee-addition',
  templateUrl: './employee-addition.component.html',
  styleUrls: ['./employee-addition.component.css']
})
export class EmployeeAdditionComponent implements OnInit {

  constructor(
    public formBuilder: FormBuilder,
    public service: SpringbootPmsServicesService,
    ) { }

  //herp={ firstname: '', lastname:'',emailid:'',Authorizer:'' }
profileTable:Profile;
  Val: FormGroup;
  UG;PG;
  dropdownList ;
  selectedItems = [];
  dropdownSettings ;
  userForm:FormGroup;data;settings;exp

  ngOnInit() {
    this.userForm = this.formBuilder.group({
      firstName: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
      lastName: ['',[Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
      email: ['', [Validators.required]],
      DOB:[ Validators.required],
      Phone:[ Validators.required],
      itemsPerPage:[],
      idField:[]
    });
    this.UG=[
      {id:1,name:'B.E'},
      {id:2,name:'B.Tech'},
      {id:3,name:'B.Sc'},      
    ]
    this.PG=[
      {id:1,name:'M.E'},
      {id:2,name:'M.Tech'},
      {id:3,name:'M.Sc'},
      {id:3,name:'Phd'},
    ]
    this.exp=[
      {id:1,name:'Newbie'},
      {id:1,name:'2+ Years'},
      {id:2,name:'4+ Years'},
      {id:3,name:'6+ Years'},
      {id:3,name:'8+ years'},
    ]
    this.dropdownList = [
      { item_id: 1, item_text: 'C++' },
      { item_id: 2, item_text: 'Unity 3D' },
      { item_id: 3, item_text: 'Unity' },
      { item_id: 4, item_text: 'UnReal Engine' },
      { item_id: 5, item_text: 'GDevelop' }
    ];
    this.selectedItems = [
      { item_id: 3, item_text: 'Unity' },
      { item_id: 4, item_text: 'unReal Engine' }
    ];
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      closeDropDownOnSelection: false,
      showSelectedItemsAtTop: false,
      
    };
    this.profileTable=new Profile(0,"","","","","","","","","","","","","","","","","",0)
    
  }

  onSubmit(){
    if(this.userForm.valid){
      alert('User form is valid!!')
    } else {
      alert('User form is not valid!!')
    }
  }
  

onSelect(event:any){
console.log(event)
} 

onSelectAll(event:any){
console.log(event)
}

onItemSelect(event:any){
  console.log(event)
}

profileExixts=false;
userExists=false;

saveProfile(){
  this.service.saveProfile(this.profileTable)
   .subscribe((data: ServiceStatus) => {

    this.profileExixts=false;
    this.userExists=false;

    if (data.serviceStatus === "INVALID_DATA") {
      this.userExists = false;
      this.profileExixts = false;
    } else if (data.serviceStatus === "PROFILE_ALREADY_EXISTS") {
      this.profileExixts = true;
    } else if (data.serviceStatus === "USER_DOES_NOT_EXIST") {
       this.userExists = false;
    } else if (data.serviceStatus === "PROFILE_SAVED") {
      this.userExists = true;
      this.profileExixts = false;
      // this.router.navigate(['head/login'])
    } else {
      console.log('server resp not identified'+data.serviceStatus);
      
    }

  }
  
  )
}
}
