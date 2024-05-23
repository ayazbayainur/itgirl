package itgirl.libraryproject.service.impl;

import itgirl.libraryproject.dto.AuthorDto;
import itgirl.libraryproject.dto.BookDto;
import itgirl.libraryproject.model.Book;
import itgirl.libraryproject.repository.BookRepository;
import itgirl.libraryproject.service.BookService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
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

    @Override
    public BookDto getBookByNameVersion1(String name) {
        Book book = bookRepository.findBookByName(name).orElseThrow();
        return convertToDto(book);
    }

    @Override
    public BookDto getBookByNameVersion2(String name){
        Book book = bookRepository.findBookBynameBySql(name).orElseThrow();
        return convertToDto(book);
    }

    @Override
    public BookDto getBookByNameVersion3(String name){
        Specification<Book> specification = Specification.where(new Specification<Book>(){
            @Override
            public Predicate toPredicate(Root<Book> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb){
                return cb.equal(root.get("name"), name);
            }
        });
        Book book = bookRepository.findOne(specification).orElseThrow();
        return convertToDto(book);

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
