package lt.simas.bookmanagementwithspring.services;

import lt.simas.bookmanagementwithspring.exceptions.BookNotFoundException;
import lt.simas.bookmanagementwithspring.model.Book;
import lt.simas.bookmanagementwithspring.model.BookDTO;
import lt.simas.bookmanagementwithspring.repositories.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book addBook(Book book) {
        return this.bookRepo.save(book);
    }

    public Book findBookById(Long id) {
        return this.bookRepo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public void deleteBook(Long id) {
        Book book = findBookById(id);
        this.bookRepo.delete(book);
    }

    public Book updateBook(Long id, BookDTO bookDTO) {
        Book book = findBookById(id);
        book.setPrice(bookDTO.getPrice());
        book.setPages(bookDTO.getPages());
        book.setTitle(bookDTO.getTitle());
        return this.bookRepo.save(book);
    }
}
