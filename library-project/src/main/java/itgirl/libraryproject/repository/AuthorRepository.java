package itgirl.libraryproject.repository;

import itgirl.libraryproject.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {
    Optional<Author> findAuthorByName(String name);
    @Query(nativeQuery = true, value = "SELECT * FROM AUTHOR WHERE firstname = ?")
    Optional<Author> findAuthorByNameBySql(String name);
}
