package slabodchikov.tritpo.candy_shop.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import slabodchikov.tritpo.candy_shop.backend.entity.CreditCard;
import slabodchikov.tritpo.candy_shop.backend.service.CreditCardService;

@RestController
@RequestMapping("/api/credit-cards")
public class CreditCardController {

    private CreditCardService creditCardService;

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping
    public Iterable<CreditCard> findAll() {
        return creditCardService.findAll();
    }

    @GetMapping(value = "/{cardId}")
    public CreditCard findById(@PathVariable(name = "cardId") Long id) {
        return creditCardService.findById(id).orElse(null);
    }

    @DeleteMapping(value = "/{cardId}")
    public void deleteById(@PathVariable(name = "cardId") Long id) {
        creditCardService.deleteById(id);
    }

    @PostMapping
    public CreditCard save(@RequestBody CreditCard creditCard) {
        return creditCardService.save(creditCard);
    }
}
