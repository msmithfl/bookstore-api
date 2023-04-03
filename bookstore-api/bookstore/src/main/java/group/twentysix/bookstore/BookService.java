package group.twentysix.bookstore;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Book> allBooks() {
        return bookRepository.findAll();

    }
    public Optional<Book> singleBook(String isbn){

        return bookRepository.findBookByisbn(isbn);
    }
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
    }



