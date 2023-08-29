package proyecto.springbootlogin.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/home")
    public String Home(){//ResponseEntity<?>

        String home = "Home";
        return home;
        //return new ResponseEntity(HttpStatus.OK);
    }
}
