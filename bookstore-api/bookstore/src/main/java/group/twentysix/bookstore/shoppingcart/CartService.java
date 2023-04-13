package group.twentysix.bookstore.shoppingcart;

import group.twentysix.bookstore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService  {

    private CartRepository cartRepository;
    private CartRequestToCart cartRequestToCart;

    @Autowired
    public CartService(CartRepository cartRepository, CartRequestToCart cartRequestToCart) {
        this.cartRepository = cartRepository;
        this.cartRequestToCart = cartRequestToCart;
    }

    
    public synchronized Cart saveOrUpdate(CartRequest cartRequest) {
        return cartRepository.save(cartRequestToCart.convert(cartRequest));
    }

    public synchronized Cart findCartByCustomerId(CartRequest cartRequest) {
        return cartRepository.findCartByCustomerId(cartRequest.getCustomerId());
    }

    
    public List<Cart> findAllCarts() {
        return cartRepository.findAll();
    }
}