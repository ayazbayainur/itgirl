package itgirl.libraryproject.controller;

import itgirl.libraryproject.dto.BookDto;
import itgirl.libraryproject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book/")
public class BookController {
    private final BookService bookService;

    @GetMapping("id/{id}")
    public BookDto getBookById(@PathVariable("id") Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("bookname1")
    BookDto getBookByName1(@RequestParam("name") String name){
        return bookService.getBookByNameVersion1(name);
    }

    @GetMapping("bookname2")
    BookDto getBookByName2(@RequestParam("name") String name){
        return bookService.getBookByNameVersion2(name);
    }

    @GetMapping("bookname3")
    BookDto getBookByName3(@RequestParam("name") String name){
        return bookService.getBookByNameVersion3(name);
    }
}
