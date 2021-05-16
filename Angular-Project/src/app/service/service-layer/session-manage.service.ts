import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionManageService {

  constructor() { }
  aunthenticate(username,name,email,user_id){

    sessionStorage.setItem("authenticateUser",username);
    sessionStorage.setItem("authenticatename",name);
    sessionStorage.setItem("authenticateemail",email);
    sessionStorage.setItem("getUserId",user_id)   
    }
//     userdet(userId){
//  sessionStorage.setItem("getUserId",userId)
//     }

getUserName(){
  let userName=sessionStorage.getItem('authenticateUser');
  return userName;
  
}
getUserFullname(){
  let name=sessionStorage.getItem('authenticatename')
  return name;
}
getUserEmail(){
  let email=sessionStorage.getItem('authenticateemail')
  return email;
}

getUserId(){
  let id=sessionStorage.getItem('getUserId')
  return id;
}

isUserLoggedIn(){
  let user = sessionStorage.getItem('authenticateUser')
   return !(user==null);
   
}



logout(){
  sessionStorage.removeItem('authenticateUser')
   
}


}
