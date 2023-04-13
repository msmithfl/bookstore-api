package group.twentysix.bookstore.shoppingcart;

import group.twentysix.bookstore.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findCartByCustomerId(String customerId);
    Cart void removeByBook(Object book);
}