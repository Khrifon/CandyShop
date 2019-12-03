package slabodchikov.tritpo.candy_shop.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import slabodchikov.tritpo.candy_shop.backend.entity.Product;
import slabodchikov.tritpo.candy_shop.backend.service.ProductService;

@RestController
@RequestMapping(value = "/api/products")
public class ProductRepository {

    private ProductService productService;

    @Autowired
    public ProductRepository(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable(name = "id") Long id) {
        return productService.findById(id).orElse(null);
    }
}
