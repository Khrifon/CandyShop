package slabodchikov.tritpo.candy_shop.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import slabodchikov.tritpo.candy_shop.backend.entity.Cart;
import slabodchikov.tritpo.candy_shop.backend.service.CartService;

@RestController
@RequestMapping(value = "/api/carts")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public Iterable<Cart> findAll() {
        return cartService.findAll();
    }

    @GetMapping(value = "/{cartId}")
    public Cart findById(@PathVariable(name = "cartId") Long id) {
        return cartService.findById(id).orElse(null);
    }

    @DeleteMapping(value = "/{cartId}")
    public void deleteById(@PathVariable(name = "cartId") Long id) {
        cartService.deleteById(id);
    }

    @PostMapping
    public Cart save(@RequestBody Cart cart) {
        return cartService.save(cart);
    }

    @GetMapping(value = "/user/{userId}")
    public Cart findByUserId(@PathVariable(name = "userId") Long id) {
        return cartService.findByUserId(id);
    }
}
