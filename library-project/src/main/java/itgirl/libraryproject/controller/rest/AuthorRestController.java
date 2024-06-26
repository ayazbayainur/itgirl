package itgirl.libraryproject.controller.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import itgirl.libraryproject.dto.AuthorCreateDto;
import itgirl.libraryproject.dto.AuthorDto;
import itgirl.libraryproject.dto.AuthorUpdateDto;
import itgirl.libraryproject.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@RestController
@RequiredArgsConstructor
@RequestMapping("/author-rest/")
@SecurityRequirement(name = "library-users")
public class AuthorRestController {
    private final AuthorService authorService;

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
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

    @PostMapping("create")
    AuthorDto createAuthor(@RequestBody @Valid AuthorCreateDto authorCreateDto){
        try{
            return authorService.createAuthor(authorCreateDto);
        } catch(Exception ex){
            System.out.println("Author already exists");
        }
        return null;
    }

    @PutMapping("update")
    AuthorDto updateAuthor(@RequestBody AuthorUpdateDto authorUpdateDto){
        try {
            return authorService.updateAuthor(authorUpdateDto);
        } catch(Exception ex){
            System.out.println("Author does not exist");
        }
        return null;
    }

    @DeleteMapping("delete/{id}")
    AuthorDto deleteAuthor(@PathVariable("id") Long id){
        return authorService.deleteAuthor(id);
    }

    @GetMapping("all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getBooksView(Model model){
        model.addAttribute("authors", authorService.getAllBooks());
        return "authors";
    }

}
