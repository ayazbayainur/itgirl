package itgirl.libraryproject.repository;

import itgirl.libraryproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    Optional<Book> findBookByName(String name);
    @Query(nativeQuery = true, value = "SELECT * FROM BOOK WHERE firstname = ?")
    Optional<Book> findBookBynameBySql(String name);
}
