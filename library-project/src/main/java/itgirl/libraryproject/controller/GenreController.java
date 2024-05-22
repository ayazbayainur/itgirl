package itgirl.libraryproject.controller;

import itgirl.libraryproject.dto.GenreDto;
import itgirl.libraryproject.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/genre/")
public class GenreController {
    private final GenreService genreService;

    @GetMapping("{id}")
    public GenreDto getGenreById(@PathVariable("id") Long id){
        return genreService.getGenreById(id);
    }
}
