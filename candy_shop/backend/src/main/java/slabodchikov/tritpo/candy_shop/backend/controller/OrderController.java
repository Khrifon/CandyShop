package slabodchikov.tritpo.candy_shop.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import slabodchikov.tritpo.candy_shop.backend.entity.Order;
import slabodchikov.tritpo.candy_shop.backend.service.OrderService;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Iterable<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping(value = "/{orderId}")
    public Order findById(@PathVariable(name = "orderId") Long id) {
        return orderService.findById(id).orElse(null);
    }

    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

    @DeleteMapping(name = "/{orderId}")
    public void deleteById(@PathVariable(name = "orderId") Long id) {
        orderService.deleteById(id);
    }
}
