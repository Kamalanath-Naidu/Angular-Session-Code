import { Component, OnInit } from '@angular/core';
import { SpringbootPmsServicesService } from './../service/service-layer/springboot-pms-services.service';
import { SessionManageService } from './../service/service-layer/session-manage.service';

export class Profile {

  constructor(
    public profile_id: number,
    public first_name: string,
    public last_name: string,
    public nuemail_id: string,
    public phone: number,
    public gender: string,
    public undergrade: string,
    public postgrade: string,
    public techeng: string,
    public exp: string,
    public user_id: number,
    public preproject: string
  ) { }
}

export class ProfilePagination {

  constructor(
    public totalItems: number,
     public totalPages: number,
    public itemsPerPage: number,//
    public currentPage: number,
    public profiles: Profile[]
  ) { }
}

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  page = 1;
  count = 0;
  itemsPerPage=1;
  tableSize = 1;
  pagesize;//totalsizes/totalpages
  pageSizes = [1, 2, 3];
  profilePagination: ProfilePagination;
  head = [
    'Profile Id', 'First Name', 'Last Name', 'Email id',
    'Phone Number', 'Gender', 'UG', 'PG', 'Tech stack', 'EXP', 'Onboarding User', 'Previous Project'
  ];
  selectedChoiceName;
  searchInput: any;

  choices = [
    { id: 1, name: 'Profile Id' },
    { id: 2, name: 'First Name' },
    { id: 3, name: 'Last Name' },
    { id: 4, name: 'Tech Stack' },
    { id: 5, name: 'Onboarding User' }
  ];


  ifschoices: string[];
  displayProfiles: Profile[];

  constructor(
    public servicelay: SpringbootPmsServicesService,
    public sessionmanage : SessionManageService
    ) { }

  ngOnInit(): void {
    this.getprofile();
   console.log("userid: "+this.sessionmanage.getUserId()+" Mailid: "+this.sessionmanage.getUserEmail())
    
  }

  onTableSizeChange(event) {
    this.tableSize = event.target.value;
    this.page = 3;
    this.getprofile();
  }

  onTableDataChange(event) {
    this.page = event;
    this.getprofile();
  }

  getParam(user_id,page, pagesize){
    let params={}
    if(user_id){
      params['user_id']=1001;//user_id;
    }
    if(page){
      params['page']=page-1;
    }
    if(pagesize){
      params['size']=pagesize;
    }
return params;
  }

  getprofile() {

    let params=this.getParam( this.sessionmanage.getUserId(),this.page,this.pagesize)
    this.servicelay.profileFetchWithId(params).subscribe((data) => {
      this.response(data)
      console.log(data);
    });
  }

  response(value: ProfilePagination) {
    this.profilePagination = value;
    this.displayProfiles = this.profilePagination.profiles;
  }

  searchMethod() {
    console.log("searchInput:" + this.searchInput);
    console.log("selectedChoice:" + (this.selectedChoiceName));
    this.ifschoices = ["First Name", "Last Name", "Tech Stack"];

    if (!this.searchInput || this.searchInput === "null") {
      this.ngOnInit();
    } else {
      if (this.selectedChoiceName == this.ifschoices[0]) {
        console.log("inside fname");

        this.displayProfiles = this.profilePagination.profiles.filter((data) =>
          data.first_name.toLocaleLowerCase().includes(this.searchInput.toLocaleLowerCase())
        );
      } else if (this.selectedChoiceName == "Last Name") {
        console.log("inside lname");
        this.displayProfiles = this.profilePagination.profiles.filter((data) =>
          data.last_name.toLocaleLowerCase().includes(this.searchInput.toLocaleLowerCase())
        );
      } else if (this.selectedChoiceName == "Tech Stack") {
        console.log("inside tech");
        this.displayProfiles = this.profilePagination.profiles.filter((data) =>
          data.techeng.toLocaleLowerCase().includes(this.searchInput.toLocaleLowerCase())
        );
      }
    }
  }

}
