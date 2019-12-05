package slabodchikov.tritpo.candy_shop.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import slabodchikov.tritpo.candy_shop.backend.entity.AuthToken;
import slabodchikov.tritpo.candy_shop.backend.entity.User;
import slabodchikov.tritpo.candy_shop.backend.entity.UserToken;
import slabodchikov.tritpo.candy_shop.backend.security.JwtTokenUtil;
import slabodchikov.tritpo.candy_shop.backend.service.AuthenticationService;

@RestController
@RequestMapping(value = "")
public class AuthenticationController {

    private AuthenticationManager manager;

    private JwtTokenUtil jwtTokenUtil;

    private AuthenticationService authService;

    @Autowired
    public AuthenticationController(AuthenticationManager manager,
                                    JwtTokenUtil jwtTokenUtil,
                                    AuthenticationService authenticationService) {
        this.manager = manager;
        this.jwtTokenUtil = jwtTokenUtil;
        authService = authenticationService;
    }

    @PostMapping(value = "/token/generate-token")
    public ResponseEntity<AuthToken> generateToken(@RequestBody User user) {
        final Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getLogin(),
                        user.getPassword()
                )
        );
        return ResponseEntity.ok(new AuthToken(jwtTokenUtil.generateToken(authentication)));
    }

    @PostMapping(value = "/login")
    public UserToken login(@RequestBody User user) {
        return authService.login(user);
    }

    @PostMapping(value = "/register")
    public UserToken register(@RequestBody User user) {
        return authService.register(user);
    }
}
