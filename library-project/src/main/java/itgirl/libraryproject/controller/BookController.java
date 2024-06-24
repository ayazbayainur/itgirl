package itgirl.libraryproject.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import itgirl.libraryproject.dto.BookCreateDto;
import itgirl.libraryproject.dto.BookDto;
import itgirl.libraryproject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book/")
@SecurityRequirement(name="library-users")
public class BookController {
    private final BookService bookService;

    @GetMapping("all")
    String getBooksView(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "library";
    }

}
