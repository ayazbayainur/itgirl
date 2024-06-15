package itgirl.libraryproject.service.impl;

import itgirl.libraryproject.dto.AuthorCreateDto;
import itgirl.libraryproject.dto.AuthorDto;
import itgirl.libraryproject.dto.AuthorUpdateDto;
import itgirl.libraryproject.dto.BookDto;
import itgirl.libraryproject.model.Author;
import itgirl.libraryproject.repository.AuthorRepository;
import itgirl.libraryproject.service.AuthorService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DialectOverride;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    @Override
    public AuthorDto getAuthorById(Long id){
        Author author = authorRepository.findById(id).orElseThrow();
        return convertToDto(author);
    }

    @Override
    public AuthorDto getAuthorByNameVersion1(String name){
        Author author = authorRepository.findAuthorByName(name).orElseThrow();
        return convertToDto(author);
    }

    @Override
    public AuthorDto getAuthorByNameVersion2(String name){
        Author author = authorRepository.findAuthorByNameBySql(name).orElseThrow();
        return convertToDto(author);
    }

    @Override
    public AuthorDto getAuthorByNameVersion3(String name){
        Specification<Author> specification = Specification.where(new Specification<Author>(){
            @Override
            public Predicate toPredicate(Root<Author> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb){
                return cb.equal(root.get("name"), name);
            }
        });
        Author author = authorRepository.findOne(specification).orElseThrow();
        return convertToDto(author);
    }


    @Override
    public AuthorDto createAuthor(AuthorCreateDto authorCreateDto) throws Exception{
        if(findAuthorBySurnameAndName(authorCreateDto.getSurname(), authorCreateDto.getName()))
            throw new Exception();
        Author author = authorRepository.save(convertToEntity(authorCreateDto));
        AuthorDto authorDto = convertToDto(author);
        return authorDto;
    }

    @Override
    public AuthorDto updateAuthor(AuthorUpdateDto authorUpdateDto) throws Exception{
        Author author = authorRepository.findById(authorUpdateDto.getId()).orElseThrow();
        author.setName(authorUpdateDto.getName());
        author.setSurname(authorUpdateDto.getSurname());
        Author savedAuthor = authorRepository.save(author);
        AuthorDto authorDto = convertToDto(savedAuthor);
        return authorDto;
    }

    @Override
    public AuthorDto deleteAuthor(Long id){
        AuthorDto authorDto = convertToDto(authorRepository.findById(id).orElseThrow());
        authorRepository.deleteById(id);
        return authorDto;
    }
    @Override
    public List<AuthorDto> getAllBooks(){
        return authorRepository.findAll().stream().map(author -> convertToDto(author)).toList();
    }
    private boolean findAuthorBySurnameAndName(String surname, String name){
        List<Author> authors = authorRepository.findAll().stream().filter(author -> author.getSurname().equals(surname) && author.getName().equals(name)).toList();
        if(authors.isEmpty()) return false;
        else return true;
    }

    private Author convertToEntity(AuthorCreateDto authorCreateDto){
        return Author.builder()
                .name(authorCreateDto.getName())
                .surname((authorCreateDto.getSurname()))
                .build();
    }

    private AuthorDto convertToDto(Author author){
        List<BookDto> bookDtoList = !(author.getBooks() == null) ? author.getBooks()
                .stream()
                .map(book -> BookDto.builder()
                        .genre(book.getGenre().getName())
                        .name(book.getName())
                        .id(book.getId())
                        .build()
                ).toList() : new ArrayList<>();
        return AuthorDto.builder()
                .books(bookDtoList)
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
//                .active(author.getActive())
                .build();
    }

}
