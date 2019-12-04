package slabodchikov.tritpo.candy_shop.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import slabodchikov.tritpo.candy_shop.backend.entity.User;
import slabodchikov.tritpo.candy_shop.backend.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service("userService")
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        String encodedPassword = bcryptEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(username);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getLogin(), user.getPassword(), getAuthority());
        } else {
            throw new UsernameNotFoundException("Can not find user with such login :{}" + username);
        }
    }

    private Set<GrantedAuthority> getAuthority() {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }
}
