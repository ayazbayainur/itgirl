package itgirl.libraryproject.controller.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import itgirl.libraryproject.dto.BookCreateDto;
import itgirl.libraryproject.dto.BookDto;
import itgirl.libraryproject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book-rest/")
@SecurityRequirement(name="library-users")
public class BookRestController {
    private final BookService bookService;


    @GetMapping("id/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public BookDto getBookById(@PathVariable("id") Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("bookname1")
    BookDto getBookByName1(@RequestParam("name") String name){
        return bookService.getBookByNameVersion1(name);
    }

    @PostMapping("create")
    BookDto createBook(@RequestBody BookCreateDto bookCreateDto){
        return bookService.createBook(bookCreateDto);
    }

    @GetMapping("all")
    List<BookDto> getAllBooks(){
        return bookService.getAllBooks();
    }

}
