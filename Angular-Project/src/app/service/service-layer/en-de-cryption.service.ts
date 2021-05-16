import { IvyParser } from '@angular/compiler';
import { Injectable } from '@angular/core';
import * as CryptoJS from 'crypto-js';
import { SessionManageService } from './../../service/service-layer/session-manage.service';


@Injectable({
  providedIn: 'root'
})
export class EnDeCryptionService {

  constructor(private KeyofUser: SessionManageService) { }
  // iv :string  = "0123456789asdfgh";
  iv = CryptoJS.enc.Utf8.parse('')

  getRandomIVsecurecode() {
    let finalIVcode: string = "";
    let stringRepo: string = 'asdfghjklzxcvbnmqwertyuiopASDFGHJKLQWERTYUIOPZMNBVXC1234567890';

    for (let i = 0; i < 16; i++) {
      finalIVcode += stringRepo.charAt(Math.floor(Math.random() * 16));
    }
    // console.log("Iv: " + finalIVcode);
    return finalIVcode;

  }

  //key= CryptoJS.enc.Utf8.parse('09897654321i235a');//UTF coverts to ETF 8 into hexadecimal
  key = CryptoJS.enc.Utf8.parse(this.KeyofUser.getUserName());
  Ivstring;

  encrypt(value, username) {
    this.iv = CryptoJS.enc.Utf8.parse(this.getRandomIVsecurecode());//this.getRandomIVsecurecode()

    this.Ivstring = this.iv.toString(CryptoJS.enc.Utf8);

    //this.key= CryptoJS.enc.Utf8.parse(username);
    for (var j = username.length; j < 16; j++) {
      username += 0;
    }

    const encrypted = CryptoJS.AES.encrypt(CryptoJS.enc.Utf8.parse(value.toString()), CryptoJS.enc.Utf8.parse(username.toString()), {
      keySize: 192 / 8,
      iv: this.iv,
      mode: CryptoJS.mode.CBC,
      padding: CryptoJS.pad.Pkcs7
    });
    /**replaced Key by CryptoJS.enc.Utf8.parse(username.toString()) */

    console.log('IV inside encrypt: ' + this.iv.toString(CryptoJS.enc.Utf8));

    console.log("Key avl: " + username)
    return encrypted.toString();

  }



  decrypt(value, userkey, inputiv) {


    for (var j = userkey.length; j < 16; j++) {
      userkey += 0;
    }

    // console.log("encrpted i/p  :  "+ value)
    // console.log("userkey  : " + userkey)
    // console.log("i/p iv : " + inputiv)

    const decrypted = CryptoJS.AES.decrypt(value, CryptoJS.enc.Utf8.parse(userkey.toString()), {
      keySize: 192 / 8,
      iv: CryptoJS.enc.Utf8.parse(inputiv),
      mode: CryptoJS.mode.CBC,
      padding: CryptoJS.pad.Pkcs7

    })
    //console.log(this.iv.toString());
    console.log("userkey post padding:" + userkey)
    console.log("decpted val" + decrypted.toString());
    return decrypted.toString(CryptoJS.enc.Utf8);//(CryptoJS.enc.Utf8
  }

}
