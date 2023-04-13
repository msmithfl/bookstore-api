package group.twentysix.bookstore.shoppingcart;

import group.twentysix.bookstore.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST}, allowCredentials = "true", origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/cart")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity create(@RequestBody CartRequest cartRequest) {
    	
            Cart cart = cartService.saveOrUpdate(cartRequest);
            return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @GetMapping(value = "/cartbycustomerid")
    public ResponseEntity getCartByCustomerId(@RequestBody CartRequest cartRequest) {
    	Cart cart = cartService.findCartByCustomerId(cartRequest);
            return new ResponseEntity<>(cart, HttpStatus.OK);
    }
    @GetMapping(value = "/carts")
    public ResponseEntity getCarts() {
    	List<Cart> carts = cartService.findAllCarts();
            return new ResponseEntity<>(carts, HttpStatus.OK);
			
		}
    
}