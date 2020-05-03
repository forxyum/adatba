import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { User } from '../../model/user';
import { map } from'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private customerUrl:string;
  private supplierUrl:string;


  constructor(private http:HttpClient) { 
    this.customerUrl = 'http://localhost:8081/customers';
    this.supplierUrl = 'http://localhost:8081/suppliers';
  }
  public save(user:User){
    console.log(user);
    if(user.address){
      return this.http.post<User>(this.customerUrl,user);
    }
    else if(user.balance){
      return this.http.post<User>(this.supplierUrl,user);
    }
    else{
      console.log("hát ez szopó tesám");
    }
  }
  public loginCust(username:string,passoword:string){
    return this.http.get('http://localhost:8081/customers/' + username);
  }
  public loginSupp(username:string,passoword:string){
    return this.http.get('http://localhost:8081/suppliers/' + username);
  }
  public logout(){
    localStorage.setItem('isLoggedIn', 'false');
    localStorage.removeItem('token');
  }
}
