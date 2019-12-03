package slabodchikov.tritpo.candy_shop.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import slabodchikov.tritpo.candy_shop.backend.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
