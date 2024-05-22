package itgirl.libraryproject.service;

import itgirl.libraryproject.dto.AuthorDto;
import itgirl.libraryproject.model.Author;
import org.springframework.stereotype.Service;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);

}
