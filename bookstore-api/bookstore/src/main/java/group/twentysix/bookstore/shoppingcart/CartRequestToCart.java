package group.twentysix.bookstore.shoppingcart;

import group.twentysix.bookstore.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CartRequestToCart implements Converter<CartRequest, Cart> {

    @Override
    public Cart convert(CartRequest cartRequest) {
        Cart cart = new Cart();
        if (!StringUtils.isEmpty(cartRequest.getId())) {
            cart.setId(cartRequest.getId());
        }
        cart.setCustomerId(cartRequest.getCustomerId());
        cart.setBooks(cartRequest.getBooks());
        return cart;
    }
}
