package itgirl.libraryproject.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import itgirl.libraryproject.dto.AuthorCreateDto;
import itgirl.libraryproject.dto.AuthorDto;
import itgirl.libraryproject.dto.AuthorUpdateDto;
import itgirl.libraryproject.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@RequiredArgsConstructor
@RequestMapping("/author/")
@SecurityRequirement(name = "library-users")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getBooksView(Model model){
        model.addAttribute("authors", authorService.getAllBooks());
        return "authors";
    }

}
