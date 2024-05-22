package itgirl.libraryproject.service.impl;

import itgirl.libraryproject.dto.AuthorDto;
import itgirl.libraryproject.dto.BookDto;
import itgirl.libraryproject.model.Book;
import itgirl.libraryproject.model.Genre;
import itgirl.libraryproject.repository.BookRepository;
import itgirl.libraryproject.repository.GenreRepository;
import itgirl.libraryproject.service.GenreService;
import itgirl.libraryproject.dto.GenreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    @Override
    public GenreDto getGenreById(Long id){
        return convertToDto(genreRepository.findById(id).orElseThrow());
    }

    private GenreDto convertToDto(Genre genre){
        List<BookDto> books = bookRepository.findAll()
                .stream()
                .filter(book -> book.getGenre().getId() == genre.getId())
                .map(book -> BookDto.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .authors(book.getAuthors()
                                .stream()
                                .map(author -> AuthorDto.builder()
                                        .name(author.getName())
                                        .surname(author.getSurname())
                                        .id(author.getId()).build()).toList()).build()).toList();

        return GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .books(books)
                .build();
    }
}
