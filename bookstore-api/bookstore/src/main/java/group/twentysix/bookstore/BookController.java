package group.twentysix.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<List<Book>>(bookService.allBooks(), HttpStatus.OK);
    }

    @GetMapping("/{publisher}")
    public ResponseEntity<List<Book>> getBooksByPublisher(@PathVariable String publisher) {
        return new ResponseEntity<List<Book>>(bookRepository.findByPublisher(publisher), HttpStatus.OK);
    }

    @GetMapping("/top-sellers")
    public ResponseEntity<List<Book>> getTopSellers() {
        return new ResponseEntity<List<Book>>(bookRepository.findTop5ByOrderByAmountSoldDesc(), HttpStatus.OK);
    }
}
