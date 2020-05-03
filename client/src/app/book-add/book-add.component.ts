import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm, FormControl, Validators } from '@angular/forms';
import { BookService } from '../shared/book/book.service';
import { Book } from '../model/book';

@Component({
  selector: 'app-book-add',
  templateUrl: './book-add.component.html',
  styleUrls: ['./book-add.component.css']
})
export class BookAddComponent implements OnInit {
  maxDate: Date;
  file = new FormControl('', Validators.required);
  thisYear;
  book = new Book();

  constructor(private route:ActivatedRoute,private router:Router,private bookService:BookService) { }

  ngOnInit(): void {
    this.maxDate = new Date();
    this.maxDate.setFullYear(this.maxDate.getFullYear() - 18);
    this.thisYear = new Date().getFullYear();
  }

  onSubmit(form:NgForm){
    console.log(form);
    this.book.title = form.value.title;
    this.book.publisher = form.value.publisher;
    this.book.year = new Date(form.value.year + '-01-01T12:00:00');
    this.book.pic = null;
    console.log(this.book);
    this.bookService.addBook(this.book);
  }
}
