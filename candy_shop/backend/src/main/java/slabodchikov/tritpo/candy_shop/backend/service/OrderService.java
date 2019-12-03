package slabodchikov.tritpo.candy_shop.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slabodchikov.tritpo.candy_shop.backend.entity.Order;
import slabodchikov.tritpo.candy_shop.backend.repository.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }
}
