package dev.pronunciationAppBack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

    @GetMapping("/hello")
    public String hello() {
        return "hello Emiliano, are you sleeping?";
    }



}
