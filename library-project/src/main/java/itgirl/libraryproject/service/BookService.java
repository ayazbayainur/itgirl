package itgirl.libraryproject.service;

import itgirl.libraryproject.dto.BookDto;
import itgirl.libraryproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookService {
    BookDto getBookById(Long id);
}
