package group.twentysix.bookstore;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, ObjectId> {

    List<Book> findByPublisher(String publisher);
}
