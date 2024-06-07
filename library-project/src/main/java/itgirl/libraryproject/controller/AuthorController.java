package itgirl.libraryproject.controller;

import itgirl.libraryproject.dto.AuthorCreateDto;
import itgirl.libraryproject.dto.AuthorDto;
import itgirl.libraryproject.dto.AuthorUpdateDto;
import itgirl.libraryproject.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
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

    @PostMapping("create")
    AuthorDto createAuthor(@RequestBody AuthorCreateDto authorCreateDto){
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
    public String getBooksView(Model model){
        model.addAttribute("authors", authorService.getAllBooks());
        return "authors";
    }
}
