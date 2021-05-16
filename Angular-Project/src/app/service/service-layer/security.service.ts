import { Injectable } from '@angular/core';
import * as CryptoJS from 'crypto-js';
import {SessionManageService} from './../../service/service-layer/session-manage.service';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  constructor(private KeyofUser:SessionManageService ) { }
  

  getRandomIVsecurecode(){
    let finalIVcode:string;
    let stringRepo: string ='asdfghjklzxcvbnmqwertyuiopASDFGHJKLQWERTYUIOPZMNBVXC1234567890';
    
    for(let i=0;i<16;i++){
        finalIVcode +=    stringRepo.charAt(Math.floor( Math.random() * 16 ));
    }
  return finalIVcode;
  
  }
  
  //key= CryptoJS.enc.Utf8.parse('09897654321i235a');//UTF coverts to ETF 8 into hexadecimal
  key= CryptoJS.enc.Utf8.parse(this.KeyofUser.getUserName());
  iv:string;
  
  encrypt(value){
    this.iv = CryptoJS.enc.Utf8.parse(this.getRandomIVsecurecode());
    
  const encrypted= CryptoJS.AES.encrypt(CryptoJS.enc.Utf8.parse(value.toString()),this.key,{
    keySize: 192/8,
    iv: this.iv,
    mode: CryptoJS.mode.CBC,
    padding: CryptoJS.pad.Pkcs7
  });
  
  return encrypted.toString;
  
  }
  
  decrypt(value){
    const decrypted=CryptoJS.AES.decrypt(value,this.key,{
      keySize: 192/8,
      iv: this.iv,
      mode: CryptoJS.mode.CBC,
      padding: CryptoJS.pad.Pkcs7
    });
  
    return decrypted.toString(CryptoJS.enc.Utf8);
  }
}
