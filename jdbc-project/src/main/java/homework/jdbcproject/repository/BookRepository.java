package homework.jdbcproject.repository;

import homework.jdbcproject.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {
    List<Book> findAllBooks();
    Book getBookById(Long id);
}
