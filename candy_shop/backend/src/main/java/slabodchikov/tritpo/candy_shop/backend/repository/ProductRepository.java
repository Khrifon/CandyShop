package slabodchikov.tritpo.candy_shop.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import slabodchikov.tritpo.candy_shop.backend.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
