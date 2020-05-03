import { Component, OnInit, Input } from '@angular/core';
import { BookService } from '../shared/book/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  columns:number;
  height:number;
  books: Array<any>;
  

  constructor(private bookService:BookService) { }

  ngOnInit(): void {
    this.height = 900;
    this.bookService.getAll().subscribe(data =>{
      this.books = data.sort((a,b) => (a.year>b.year)? -1: 1);
    });
    this.columns = Math.floor(window.innerWidth/250)
    this.height = 900;
  }
  onResize(event) {
    this.columns = Math.floor((event.target.innerWidth/250));
  }
  newBook(id){
    this.bookService.changeBook(id);
    console.log(id);
  }

}
