package slabodchikov.tritpo.candy_shop.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import slabodchikov.tritpo.candy_shop.backend.entity.AuthToken;
import slabodchikov.tritpo.candy_shop.backend.entity.User;
import slabodchikov.tritpo.candy_shop.backend.entity.UserToken;
import slabodchikov.tritpo.candy_shop.backend.security.JwtTokenUtil;

import java.util.Optional;

@Service
public class AuthenticationService {
    private JwtTokenUtil jwtTokenUtil;

    private UserService userService;

    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(JwtTokenUtil jwtTokenUtil, UserService userService, AuthenticationManager authenticationManager) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    public UserToken register(User user) {
        user = userService.save(user);
        String token = generateToken(user, false);
        return new UserToken(user, new AuthToken(token));
    }

    public UserToken login(User user) {
        try {
            Optional<User> catchUser = userService.findByLogin(user.getLogin());
            String token = generateToken(user, true);
            return new UserToken(catchUser.orElse(null), new AuthToken(token));
        } catch (AuthenticationException e) {
            return null;
        }
    }

    private String generateToken(User user, boolean needAuthenticate) {
        UserDetails userDetails = userService.loadUserByUsername(user.getLogin());

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails, user.getPassword(), userDetails.getAuthorities()
        );

        if (needAuthenticate) {
            authenticationManager.authenticate(authenticationToken);
        }

        if (authenticationToken.isAuthenticated())
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return jwtTokenUtil.generateToken(authenticationToken);
    }
}
