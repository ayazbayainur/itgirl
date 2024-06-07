//package itgirl.libraryproject.view;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import itgirl.libraryproject.service.BookService;
//import org.springframework.web.bind.annotation.RestController;
////import org.springframework.web.bind.annotation.RestController;
//
//@Controller
//@RequiredArgsConstructor
//public class BookController {
//
//    private final BookService bookService;
//
//    @GetMapping("/books")
//    String getBooksView(Model model) {
//        model.addAttribute("books", bookService.getAllBooks());
//        return "library";
//    }
//
//}