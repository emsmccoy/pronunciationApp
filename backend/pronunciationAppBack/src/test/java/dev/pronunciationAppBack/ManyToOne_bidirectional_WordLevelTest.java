package dev.pronunciationAppBack;

import dev.pronunciationAppBack.model.Level;
import dev.pronunciationAppBack.model.Word;
import dev.pronunciationAppBack.repository.LevelRepository;
import dev.pronunciationAppBack.repository.WordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ManyToOne_bidirectional_WordLevelTest {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private LevelRepository levelRepository;

    @Test
    @Transactional
    void WordLevelRelationship() {
        // Create and persist Level
        Level level = new Level();
        level.setId("level_1");
        level.setNumber(1);
        level.setName("Beginner");
        level.setRequiredScore(100);
        level.setBlocked(false);
        level.setWords(new ArrayList<>());
        Level savedLevel = levelRepository.save(level);

        // Create and persist Word
        Word word = new Word();
        word.setId("word_1");
        word.setText("Hello");
        word.setDefinition("Greeting");
        word.setPhoneticSpelling("hello");
        word.setDifficulty(1);
        word.setCommon(true);
        word.setSentence("Hello world!");
        word.setActive(true);
        word.setLevel(savedLevel);
        savedLevel.getWords().add(word);

        Word savedWord = wordRepository.save(word);

        // Test Word Level relationship
        assertNotNull(savedWord.getLevel(), "Word should have a level");
        assertEquals(savedLevel.getId(), savedWord.getLevel().getId(),
                "Word level ID mismatch");

        // Test Level → Word relationship
        Level retrievedLevel = levelRepository.findById("level_1")
                .orElseThrow();
        List<Word> levelWords = retrievedLevel.getWords();

        assertFalse(levelWords.isEmpty(),
                "Level should have associated words");
        assertEquals(1, levelWords.size(),
                "Level should have exactly 1 word");
        assertEquals("word_1", levelWords.get(0).getId(),
                "Word ID in level's list mismatch");
    }
}

