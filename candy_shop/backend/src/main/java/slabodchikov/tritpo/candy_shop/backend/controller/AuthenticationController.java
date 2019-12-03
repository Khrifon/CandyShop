package slabodchikov.tritpo.candy_shop.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import slabodchikov.tritpo.candy_shop.backend.entity.AuthToken;
import slabodchikov.tritpo.candy_shop.backend.entity.User;
import slabodchikov.tritpo.candy_shop.backend.security.JwtTokenUtil;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping(value = "/token")
public class AuthenticationController {

    private AuthenticationManager manager;

    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthenticationController(AuthenticationManager manager, JwtTokenUtil jwtTokenUtil) {
        this.manager = manager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<AuthToken> register(@RequestBody User user) throws AuthenticationException {
        final Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getLogin(),
                        user.getPassword()
                )
        );
        return ResponseEntity.ok(new AuthToken(jwtTokenUtil.generateToken(authentication)));
    }
}
