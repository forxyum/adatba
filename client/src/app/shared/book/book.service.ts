import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject, Subject } from 'rxjs';
import { map } from'rxjs/operators';
import { Purchase } from 'src/app/model/purchase';
import { ConnectableObservable } from "rxjs"
import { publish } from "rxjs/operators";
import { Book } from 'src/app/model/book';


@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { 

  }
  private search = new Subject<string>();

  private bookSource = new BehaviorSubject(1);
  currBook = this.bookSource.asObservable();

  getAll() : Observable<any>{
    return this.http.get('//localhost:8081/books');
  }
  changeBook(bookId : number){
    this.bookSource.next(bookId);
  }
  getBook(bookId:number) : Observable<any>{
    return this.http.get('//localhost:8081/books/' + bookId);
  }
  getAuthors(bookId:number) : Observable<any>{
    return this.http.get('//localhost:8081/authors/' + bookId);
  }
  getGenres(bookId:number) : Observable<any>{
    return this.http.get('//localhost:8081/genres/' + bookId);
  }
  getStores(bookId:number) : Observable<any>{
    return this.http.get('//localhost:8081/books/' +bookId +"/stores");
  }
  addToCart(bookId:number,storeAddress:string){

  }
  getStore(address:string) : Observable<any>{
    return this.http.get('//localhost:8081/stores/' + address);
  }
  getPrice(address:string, bookId:number) : Observable<any>{
    return this.http.get('//localhost:8081/prices/' +address +"/" +bookId);
  }
  addPurchase(purchase:Purchase){
    console.log("purchase added");
    //return this.http.post<Purchase>('//localhost:8081/purchases',purchase);
    const myConnectableObservable: ConnectableObservable<any> = this.http.post<Purchase>('//localhost:8081/purchases',purchase).pipe(publish()) as ConnectableObservable<any>;
    myConnectableObservable.connect();
  }
  addBook(book:Book){
    const myConnectableObservable: ConnectableObservable<any> = this.http.post<Book>('//localhost:8081/books',book).pipe(publish()) as ConnectableObservable<any>;
    myConnectableObservable.connect();
  }
  getBookPerGenre() : Observable<any>{
    return this.http.get('//localhost:8081/stats/bookpergenre');
  }
  getAuthorPerBook(){
    return this.http.get('//localhost:8081/stats/numofauth');
  }
  getAvgPrice(){
    return this.http.get('//localhost:8081/stats/avgprice');
  }
  getAvgWhole(){
    return this.http.get('//localhost:8081/stats/avgwhole');
  }
  getMoreThanAvg(){
    return this.http.get('//localhost:8081/stats/morethan');
  }
  getSumOfSpent(){
    return this.http.get('//localhost:8081/stats/somofprice');
  }
  getSumOfSpentPer(){
    return this.http.get('//localhost:8081/stats/sumofpriceper');
  }
  getEmployeePer(){
    return this.http.get('//localhost:8081/stats/employeeper');
  }
  getBookPerCust(){
    return this.http.get('//localhost:8081/stats/bookpercust');
  }
  getStockPerStore(){
    return this.http.get('//localhost:8081/stats/bookperstore');
  }
  getMostAuth(){
    return this.http.get('//localhost:8081/stats/mostauth');
  }
  getMostGenre(){
    return this.http.get('//localhost:8081/stats/mostgenre');
  }
}
