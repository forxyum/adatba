import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../auth/services/user.service';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {
  @Output() closeEmitter = new EventEmitter<void>();

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
  }

  sidenavCloser() {
    this.closeEmitter.emit();
  }
  logout(){
    this.userService.logout();
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}
