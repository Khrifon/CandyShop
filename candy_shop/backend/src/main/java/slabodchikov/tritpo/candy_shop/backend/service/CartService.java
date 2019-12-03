package slabodchikov.tritpo.candy_shop.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slabodchikov.tritpo.candy_shop.backend.entity.Cart;
import slabodchikov.tritpo.candy_shop.backend.repository.CartRepository;

import java.util.Optional;

@Service
public class CartService {

    private CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Iterable<Cart> findAll() {
        return cartRepository.findAll();
    }

    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }
}
