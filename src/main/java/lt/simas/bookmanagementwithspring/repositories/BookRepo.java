package lt.simas.bookmanagementwithspring.repositories;

import lt.simas.bookmanagementwithspring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.title like %?1%")
    List<Book> getAllByTitleLike(String title);
}
