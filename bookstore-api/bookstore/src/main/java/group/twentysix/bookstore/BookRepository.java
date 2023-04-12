package group.twentysix.bookstore;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, ObjectId> {

    // FEATURE 1: GET BOOKS BY GENRE
    List<Book> findByPublisher(String publisher);

    // FEATURE 2: GET TOP 10 SELLERS
    List<Book> findTop5ByOrderByAmountSoldDesc();

    // FEATURE 3: GET BOOKS BY RATING
    List<Book> findByRatingGreaterThanEqual(double rating);

    Optional<Book> findBookByisbn(String isbn);
    
    List<Book> findByAuthor(String author);
}
