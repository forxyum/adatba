import { Component, OnInit } from '@angular/core';
import { BookService } from '../shared/book/book.service';
import { NgForm } from '@angular/forms';
import { UserService } from '../auth/services/user.service';
import { SearchPipe } from './search-pipe';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  columns:number;
  height:number;
  books: Array<any>;
  searched:boolean = false;
  searchText;
  
  constructor(private bookService:BookService) { }

  ngOnInit(): void {
    this.height = 900;
    this.bookService.getAll().subscribe(data =>{
      this.books = data;
    });
    this.columns = Math.floor(window.innerWidth/250)
    this.height = 900;
  }
  onResize(event) {
    this.columns = Math.floor((event.target.innerWidth/250));
  }
  onSubmit(form:NgForm){

  }
}
