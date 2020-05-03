import { Component, OnInit } from '@angular/core';
import { BookService } from '../shared/book/book.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Purchase } from '../model/purchase';
import { ArgumentOutOfRangeError } from 'rxjs';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private bookService:BookService, private router: Router) { }

  cart =[];
  cart2;
  items = new Set();
  itemslist = [];
  storeSet;
  storeAddresses = [];
  books = [];
  prices = [];
  stores = [];
  counter = new Map();
  homedelivery:boolean = false;
  total = 0;


  async ngOnInit(): Promise<void> {
    this.cart = localStorage.getItem('cart').split(";");
    let item;
    for (item in this.cart){
      let temp = this.cart[item].split("#");
      this.items.add(temp[0]);
      this.itemslist.push(temp[0]);
      this.counter.set(this.cart[item],this.counter.get(this.cart[item])?this.counter.get(this.cart[item])+1:1);

      this.bookService.getBook(temp[0]).subscribe(data =>{
        this.books.push(data);
      });
      this.bookService.getPrice(temp[1],temp[0]).subscribe(data =>{
        this.prices.push(data);
      });
      this.bookService.getStore(temp[1]).subscribe(data =>{
        this.stores.push(data);
      })
      this.storeAddresses.push(temp[1]);
      await new Promise(r => setTimeout(r, 50));
    }
    this.storeSet = new Set(this.cart);
    this.cart2 = Array.from(this.storeSet);
    
    let index = 0;
    for(let [key,value] of this.counter){
        this.total += Number(value)*this.prices[index].sale;
        index++;
    }
  }
  refresh(){
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate(['cart']);
    }); 
  }

  deleteItem(item:string):void{
    if(this.cart.indexOf(item) != -1){
      this.cart.splice(this.cart.indexOf(item),1);
      localStorage.removeItem('cart');
    for(let item of this.cart){
      if(!localStorage.getItem('cart')){
        localStorage.setItem('cart',item);
      }
      else{
        localStorage.setItem('cart',localStorage.getItem('cart')+';' +item);
      }
    }
    this.refresh(); 
    }

  }
  async add(item:string,id:number):Promise<void>{
    localStorage.setItem('cart',localStorage.getItem('cart') +';'+ item);
    this.counter.get(id).set(this.counter.get(id)+1);
    //this.refresh();
    await new Promise(r => setTimeout(r, 100));
    this.router.navigate(['/catalog']);
  }

  submit():void{
    if(localStorage.getItem('cart')){
    localStorage.removeItem('cart');
    let date = Date.now();
    let username = localStorage.getItem('token');
    
   for(let [hashtag, count] of this.counter){
    let p = new Purchase();
    p.customer=username;
    let spl = hashtag.split("#");
    p.bookId=spl[0];
    p.address=spl[1];
    p.amount = count;
    p.purchaseTime = new Date(date);
    p.delivery = this.homedelivery;
    console.log(p);
    let asd = this.bookService.addPurchase(p);
   }
  }
  this.router.navigate(['/catalog']);
  }
}
