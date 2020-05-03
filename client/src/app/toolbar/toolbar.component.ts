import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../auth/services/user.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {
  @Output() toggleEmitter = new EventEmitter<void>();

  id:string;
  searchText;
  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.id=localStorage.getItem('token');
  }

  sidenavToggle() {
    this.toggleEmitter.emit();
  }

  logout(){
    this.userService.logout();
    localStorage.clear();
    this.router.navigate(['/login']);
  }
  

}
