package slabodchikov.tritpo.candy_shop.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slabodchikov.tritpo.candy_shop.backend.entity.CreditCard;
import slabodchikov.tritpo.candy_shop.backend.repository.CreditCardRepository;

import java.util.Optional;

@Service
public class CreditCardService {

    private CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public Iterable<CreditCard> findAll() {
        return creditCardRepository.findAll();
    }

    public Optional<CreditCard> findById(Long id) {
        return creditCardRepository.findById(id);
    }

    public void deleteById(Long id) {
        creditCardRepository.deleteById(id);
    }

    public CreditCard save(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }
}
