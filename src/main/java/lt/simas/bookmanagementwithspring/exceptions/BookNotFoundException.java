package lt.simas.bookmanagementwithspring.exceptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(Long id) {
        super("Book with id " + id + " was not found");
    }
}
