package slabodchikov.tritpo.candy_shop.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    /*@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
*/
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
