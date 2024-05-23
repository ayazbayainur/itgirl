package itgirl.libraryproject.service;

import itgirl.libraryproject.dto.BookDto;


import java.util.Optional;

public interface BookService {
    BookDto getBookById(Long id);
    BookDto getBookByNameVersion1(String name);
    BookDto getBookByNameVersion2(String name);
    BookDto getBookByNameVersion3(String name);
}
