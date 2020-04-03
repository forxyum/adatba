import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { 

  }


  getAll() : Observable<any>{
    return this.http.get<any[]>('//localhost:8081/books').pipe(
      map((result:any) =>{
        return result._embedded.books;
      })
    );
  }
}
