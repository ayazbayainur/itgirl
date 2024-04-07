package homework.jdbcproject.controller;

import homework.jdbcproject.entity.Book;
import homework.jdbcproject.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book/")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("all")
    public List<Book> getAllBooks(){
        return bookRepository.findAllBooks();
    }

    @GetMapping("{id}")
    public Book getBookById(@PathVariable Long id){
        return bookRepository.getBookById(id);
    }

}
