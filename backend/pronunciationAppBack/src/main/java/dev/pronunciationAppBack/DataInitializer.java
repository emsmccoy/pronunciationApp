package dev.pronunciationAppBack;

import com.github.javafaker.Faker;
import dev.pronunciationAppBack.Word;
import dev.pronunciationAppBack.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private WordRepository wordRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        // Generate and save 10 fake words
        for (int i = 0; i < 10; i++) {
            Word word = new Word();
            word.setId(faker.idNumber().valid());  // Generate a random ID
            word.setWordName(faker.lorem().word());  // Generate a random word name
            word.setDefinition(faker.lorem().sentence());  // Generate a random definition
            word.setPhoneticSpelling(faker.lorem().characters());  // Generate a fake phonetic spelling
            word.setSentence(faker.lorem().sentence());  // Generate a sentence containing the word
            word.setActive(faker.random().nextBoolean());  // Randomly set if the word is active
            word.setLevel(faker.number().numberBetween(1, 5));  // Random level between 1 and 5

            wordRepository.save(word);  // Save the generated word to the database
        }

        System.out.println("10 fake words inserted into the database.");
    }
}
