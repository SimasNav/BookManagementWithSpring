package lt.simas.bookmanagementwithspring.controllers;


import lt.simas.bookmanagementwithspring.model.Book;
import lt.simas.bookmanagementwithspring.model.BookDTO;
import lt.simas.bookmanagementwithspring.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin("http://localhost:4200/")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return this.bookService.getAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody BookDTO bookDTO){
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setPages(bookDTO.getPages());
        book.setPrice(bookDTO.getPrice());
        return this.bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        this.bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO){
        return this.bookService.updateBook(id,bookDTO);
    }
}
