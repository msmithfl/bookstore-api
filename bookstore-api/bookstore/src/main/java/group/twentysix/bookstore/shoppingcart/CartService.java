package group.twentysix.bookstore.shoppingcart;

import group.twentysix.bookstore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService  {

    private CartRepository cartRepository;
    private CartConverter cartConverter;

    @Autowired
    public CartService(CartRepository cartRepository, CartConverter cartConverter) {
        this.cartRepository = cartRepository;
        this.cartConverter = cartConverter;
    }

    
    public synchronized Cart saveOrUpdate(CartRequest cartRequest) {
        return cartRepository.save(cartConverter.convert(cartRequest));
    }

    public synchronized Cart findCartByCustomerId(CartRequest cartRequest) {
        return cartRepository.findCartByCustomerId(cartRequest.getCustomerId());
    }

    
    public List<Cart> findAllCarts() {
        return cartRepository.findAll();
    }
}