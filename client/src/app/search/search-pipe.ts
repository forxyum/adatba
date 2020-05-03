import { PipeTransform, Pipe } from '@angular/core';


@Pipe({
    name: 'searchFilter'
})
export class SearchPipe implements PipeTransform{
    transform(books: any, searchTerm:string){
        if(!books || !searchTerm){
            return books;
        }

        return books.filter(book => book.title.toLowerCase().indexOf(searchTerm.toLowerCase()) !== -1);
    }
}