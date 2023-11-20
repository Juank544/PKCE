package co.com.perficient.pkce.controller;

import co.com.perficient.pkce.model.Hero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AppController {

    private List<Hero> someHeroes = List.of(
            new Hero(1, "Iron Man"),
            new Hero(2, "Spider Man"),
            new Hero(3, "Deadpool"));

    @GetMapping("/admin")
    public ResponseEntity<String> getEndpoint(){
        return new ResponseEntity<>("Hello Admin", HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<String> getEndpoint2() {
        return new ResponseEntity<>("Hello User", HttpStatus.OK);
    }

    @GetMapping("/heroes")
    public List<Hero> heroes() {
        return someHeroes;
    }

    @GetMapping("/heroes/{id}")
    public Hero hero(@PathVariable("id") String id) {
        return someHeroes.stream()
                .filter(h -> Integer.toString(h.id()).equals(id))
                .findFirst()
                .orElse(null);
    }
}
