package dev.pronunciationAppBack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// a kind of controller that connects the view with the business logic
// the business logic is at service where the core operations are done
// rest controller just works with rest and JSON
// controller works html and templates, for example: TH
@RestController
public class WordController {
    // dependency injection: boot creates the object and injects it,
    // it also manages all the lifecycle
    // the real goal is to connect the controller with the repository
    @Autowired
    public WordRepository wordRepository;

    // maps the endpoint url to the method with the right operation: get
    @GetMapping("/hello")
    public String hello() {
        return "hello Emiliano, are you sleeping?";
    }

    @GetMapping("/words")
    // method signature (declaration): return the list of words to the view
    public List<Word> getWords() {
            // assign the words from the repository to the list words
            List<Word> words = wordRepository.findAll();
            System.out.println("Number of words: " + words.size());
            for (Word word : words) {
                System.out.println("Word: " + word);
            }
            return words;

    }

}
