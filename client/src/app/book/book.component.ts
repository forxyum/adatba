import { Component, OnInit } from '@angular/core';
import { BookService } from '../shared/book/book.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  constructor(private bookService : BookService,private route: ActivatedRoute) { }

  private bookId: number;
  private sub:any;
  book:any;
  authors:any;
  genres:any;
  stores:any;

  ngOnInit(): void {
    this.bookService.currBook.subscribe(book => this.bookId = book);
    this.sub=this.route.params.subscribe(params =>{
      this.bookId = +params['id'];
    });
    this.bookService.getBook(this.bookId).subscribe(data =>{
      this.book = data;
    });
    this.bookService.getAuthors(this.bookId).subscribe(auth =>{
      this.authors = auth;
    });
    this.bookService.getGenres(this.bookId).subscribe(gen =>{
      this.genres = gen;
    })
    this.bookService.getStores(this.bookId).subscribe(store =>{
      this.stores = store;
    })
  }
  ngOnDestroy(){
    this.sub.unsubscribe();
  }
  addToCart(bookId:number,storeAddress:string){
    if(!localStorage.getItem('cart')){
      localStorage.setItem('cart', bookId + "#" + storeAddress);
    }
    else if(!localStorage.getItem('cart').includes(bookId+"#"+storeAddress)){
      localStorage.setItem('cart',localStorage.getItem('cart')+';' + bookId + "#" + storeAddress);
    }
  }

}
