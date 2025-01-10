package dev.pronunciationAppBack;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@RestController
public class WordController {


    @Autowired
    public WordRepository wordRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello Emiliano, are you sleeping?";
    }

    @GetMapping("/words")
    public List<Word> getWords() {
            //
            List<Word> words = wordRepository.findAll();
            System.out.println("Number of words: " + words.size());
            for (Word word : words) {
                System.out.println("Word: " + word);
            }
            return words;

    }

}
