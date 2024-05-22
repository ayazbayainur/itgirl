package itgirl.libraryproject.service.impl;

import itgirl.libraryproject.dto.AuthorDto;
import itgirl.libraryproject.dto.BookDto;
import itgirl.libraryproject.model.Author;
import itgirl.libraryproject.model.Book;
import itgirl.libraryproject.model.Genre;
import itgirl.libraryproject.repository.BookRepository;
import itgirl.libraryproject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public BookDto getBookById(Long id){
        return convertToDto(bookRepository.findById(id).orElseThrow());
    }

    private BookDto convertToDto(Book book){
        List<AuthorDto> authorDtoList= book.getAuthors()
                .stream()
                .map(author -> AuthorDto.builder()
                        .name(author.getName())
                        .surname(author.getSurname())
                        .id(author.getId())
                        .build())
                .toList();

        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .genre(book.getGenre().getName())
                .authors(authorDtoList)
                .build();
    }

}
