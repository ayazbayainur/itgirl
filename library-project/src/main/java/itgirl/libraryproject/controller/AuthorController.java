package itgirl.libraryproject.controller;

import itgirl.libraryproject.dto.AuthorDto;
import itgirl.libraryproject.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author/")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("{id}")
    AuthorDto getAuthorById(@PathVariable ("id") Long id){
        return authorService.getAuthorById(id);
    }

    @GetMapping("authorname1")
    AuthorDto getAuthorByName1(@RequestParam("name") String name){
        return authorService.getAuthorByNameVersion1(name);
    }

    @GetMapping("authorname2")
    AuthorDto getAuthorByName2(@RequestParam("name") String name){
        return authorService.getAuthorByNameVersion2(name);
    }

    @GetMapping("authorname3")
    AuthorDto getAuthorByName3(@RequestParam("name") String name){
        return authorService.getAuthorByNameVersion3(name);
    }
}
