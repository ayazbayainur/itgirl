package itgirl.libraryproject.controller;

import itgirl.libraryproject.dto.BookCreateDto;
import itgirl.libraryproject.dto.BookDto;
import itgirl.libraryproject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
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

    @PostMapping("create/")
    BookDto createBook(@RequestBody BookCreateDto bookCreateDto){
        return bookService.createBook(bookCreateDto);
    }

//    @GetMapping("all")
//    List<BookDto> getAllBooks(){
//        return bookService.getAllBooks();
//    }

    @GetMapping("all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    String getBooksView(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "library";
    }

}
