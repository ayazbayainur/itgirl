package itgirl.libraryproject.controller;

import itgirl.libraryproject.dto.AuthorDto;
import itgirl.libraryproject.model.Author;
import itgirl.libraryproject.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author/")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("{id}")
    AuthorDto getAuthorById(@PathVariable ("id") Long id){
        return authorService.getAuthorById(id);
    }

}
