import { Component, OnInit } from '@angular/core';
import { BookService } from '../shared/book/book.service';

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {

  constructor(private bookService:BookService) { }

  selected;
  pressed
  data;
  columns;

  ngOnInit(): void {

  }
  async onSelected(){
    this.pressed = true;
    this.columns = [];
    switch(this.selected){
      case "bookpergenre":
        this.bookService.getBookPerGenre().subscribe(data =>{
          this.data = data;
        });
        await new Promise(r => setTimeout(r, 50));
        this.columns.push("Genre");
        this.columns.push("Number of books");
        break;
      case "authorperbook":
        this.bookService.getAuthorPerBook().subscribe(data =>{
          this.data = data;
        });
        await new Promise(r => setTimeout(r, 50));
        this.columns.push("Title of book");
        this.columns.push("Number of authors");
        break;
      case "avgprice":
        this.bookService.getAvgPrice().subscribe(data =>{
          this.data = data;
        });
        await new Promise(r => setTimeout(r, 50));
        this.columns.push("Title of book");
        this.columns.push("Average price");
        break;
      case "avgwhole":
        this.bookService.getAvgWhole().subscribe(data =>{
          this.data = data;
        });
        await new Promise(r => setTimeout(r, 50));
        this.columns.push("Title of book");
        this.columns.push("Average wholesale");
        break;
      case "morethanavg":
        this.bookService.getMoreThanAvg().subscribe(data =>{
          this.data = data;
        });
        await new Promise(r => setTimeout(r, 50));
        this.columns.push("Number of books");
        break;
      case "sumofspent":
        this.bookService.getSumOfSpent().subscribe(data =>{
          this.data = data;
        });
        await new Promise(r => setTimeout(r, 50));
        this.columns.push("Customer");
        this.columns.push("Total spendings");
        break;
      case "sumofspentper":
        this.bookService.getSumOfSpentPer().subscribe(data =>{
          this.data = data;
        });
        await new Promise(r => setTimeout(r, 50));
        this.columns.push("Customer");
        this.columns.push("Store address");
        this.columns.push("Total spendings");
        break;
      case "employeeper":
        this.bookService.getEmployeePer().subscribe(data =>{
          this.data = data;
        });
        await new Promise(r => setTimeout(r, 50));
        this.columns.push("Name of the company");
        this.columns.push("Number of employees");
        break;
      case "bookspercust":
        this.bookService.getBookPerCust().subscribe(data =>{
          this.data = data;
        });
        await new Promise(r => setTimeout(r, 50));
        this.columns.push("Customer");
        this.columns.push("Number of authors");
        break;
      case "stockperstore":
        this.bookService.getStockPerStore().subscribe(data =>{
          this.data = data;
        });
        await new Promise(r => setTimeout(r, 50));
        this.columns.push("Name of store");
        this.columns.push("Number of books in stock");
        break;
      case "mostauth":
        this.bookService.getMostAuth().subscribe(data =>{
          this.data = data;
        });
        await new Promise(r => setTimeout(r, 50));
        this.columns.push("Title of book");
        this.columns.push("Number of authors");
        break;
      case "mostgenre":
        this.bookService.getMostGenre().subscribe(data =>{
          this.data = data;
        });
        await new Promise(r => setTimeout(r, 50));
        this.columns.push("Title");
        this.columns.push("Number of genres");
        break;
    }
  }
}
