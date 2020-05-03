import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserService } from '../services/user.service';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  user:User;
  maxDate;
  role:string;
  selected = "customer";
  customer : boolean = true;

  constructor(private route:ActivatedRoute,private router:Router,private userService:UserService) { 
    this.user = new User();
  }

  ngOnInit() {
    this.maxDate = new Date();
    this.maxDate.setFullYear(this.maxDate.getFullYear() - 18);
  }
  onSubmit(form:NgForm){
    this.userService.save(form.value).subscribe(result => this.router.navigate(['/']));
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
