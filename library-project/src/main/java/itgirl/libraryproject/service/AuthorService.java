package itgirl.libraryproject.service;

import itgirl.libraryproject.dto.AuthorDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
    AuthorDto getAuthorByNameVersion1(String name);
    AuthorDto getAuthorByNameVersion2(String name);
    AuthorDto getAuthorByNameVersion3(String name);

}
