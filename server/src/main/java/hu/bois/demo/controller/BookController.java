package hu.bois.demo.controller;

import hu.bois.demo.model.Book;
import hu.bois.demo.model.Store;
import hu.bois.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class BookController {
    @Autowired
    private BookRepository repository;

    public BookController(BookRepository repo){
        this.repository = repo;
    }

    @GetMapping("/books")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value="id") Long bookId) throws ResourceNotFoundException{
        Book book = repository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :" + bookId));
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/books/{id}/pic")
    public ResponseEntity<byte[]> getBookPicById(@PathVariable(value="id") Long bookId){
        Optional<Book> book = repository.findById(bookId);
        byte[] imageBytes = null;
        if(book.isPresent()){
            imageBytes = book.get().getPic();
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }
    @GetMapping("/books/{id}/stores")
    public List<Object[]> getStoresThatSell(@PathVariable(value="id")Long bookId){
        return repository.findStoresThatSell(bookId);
    }

    @PostMapping(path = "/books", consumes = "application/json",produces = "application/json")
    public Book createBook(@Valid @RequestBody Book book){
        return repository.save(book);
    }
    @PostMapping("/books/remove")
    public void deleteBook(@RequestBody Book book){
        repository.delete(book);
    }
    /*
    @RequestMapping("/books/{id}/image")
    public ResponseEntity<Book> getImage(@PathVariable("id") Long bookId){
        final Optional<Book> retrievedBook = repository.findById(bookId);
        return  decompressBytes(retrievedBook.get().getPic());
    }
    */
    @PostMapping("books/upload")
    public void uploadBook(@RequestBody Book book){

    }
    public static byte[] decompressBytes(byte[] data){
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try{
            while(!inflater.finished()){
                int count = inflater.inflate(buffer);
                outputStream.write(buffer,0,count);
            }
            outputStream.close();
        } catch (DataFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
    public static byte[] compressBytes(byte[] data){
        Deflater deflater =  new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while(!deflater.finished()){
            int count = deflater.deflate(buffer);
            outputStream.write(buffer,0,count);
        }
        try{
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
