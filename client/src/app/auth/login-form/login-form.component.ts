import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserService } from '../services/user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  constructor(private route:ActivatedRoute,private router:Router,private userService:UserService) { 
    
  }
  role:string;
  selected = "customer";
  customer : boolean = true;

  ngOnInit(): void {
  }
  onSubmit(form:NgForm){
    if(this.customer){
      this.userService.loginCust(form.value.username,form.value.password).subscribe(res =>{
        console.log("---------------------------------------")
        console.log(res);
        console.log("---------------------------------------")
        localStorage.setItem('isLoggedIn',"true");
        localStorage.setItem('token',form.value.username);
        this.router.navigate(['/home']);
      });
    }
    else{
      this.userService.loginSupp(form.value.username,form.value.password).subscribe(res =>{
        console.log("---------------------------------------")
        console.log(res);
        console.log("---------------------------------------")
        localStorage.setItem('isLoggedIn',"true");
        localStorage.setItem('token',form.value.username);
        this.router.navigate(['/home']);
      });
    }
  }
  onRoleSelected(){
    this.role = this.selected;
    if(this.selected=="customer"){
      this.customer = true;
    }
    else{
      this.customer = false;
    }
  }


}
