package lt.simas.bookmanagementwithspring.repositories;

import lt.simas.bookmanagementwithspring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
