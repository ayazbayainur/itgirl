package itgirl.libraryproject.service;

import itgirl.libraryproject.dto.AuthorDto;
import itgirl.libraryproject.dto.AuthorCreateDto;
import itgirl.libraryproject.dto.AuthorUpdateDto;

import java.util.List;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
    AuthorDto getAuthorByNameVersion1(String name);
    AuthorDto getAuthorByNameVersion2(String name);
    AuthorDto getAuthorByNameVersion3(String name);

//    AuthorDto createAuthor(AuthorCreateDto createAuthorDto) throws Exception;
    AuthorDto createAuthor(AuthorCreateDto createAuthorDto) throws Exception;
    AuthorDto updateAuthor(AuthorUpdateDto authorUpdateDto) throws Exception;
    AuthorDto deleteAuthor(Long id);
    List<AuthorDto> getAllBooks();


}
