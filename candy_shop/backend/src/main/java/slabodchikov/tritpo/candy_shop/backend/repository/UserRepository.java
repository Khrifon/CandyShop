package slabodchikov.tritpo.candy_shop.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import slabodchikov.tritpo.candy_shop.backend.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByLogin(String login);
}
