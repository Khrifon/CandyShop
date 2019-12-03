package slabodchikov.tritpo.candy_shop.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import slabodchikov.tritpo.candy_shop.backend.entity.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
