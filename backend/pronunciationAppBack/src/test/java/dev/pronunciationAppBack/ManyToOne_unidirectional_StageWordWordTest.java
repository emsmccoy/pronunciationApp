package dev.pronunciationAppBack;

import dev.pronunciationAppBack.model.StageWord;
import dev.pronunciationAppBack.model.Status;
import dev.pronunciationAppBack.model.Word;
import dev.pronunciationAppBack.repository.StageWordRepository;
import dev.pronunciationAppBack.repository.WordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ManyToOne_unidirectional_StageWordWordTest {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private StageWordRepository stageWordRepository;

    @Test
    @Transactional
    void testStageWordWordRelationship() {
        // create and save a Word
        Word word = new Word();
        word.setId("w001");
        word.setText("Lion");
        word.setDefinition("A large wild cat found in Africa and Asia");
        word.setPhoneticSpelling("ˈlaɪ.ən");
        word.setDifficulty(3);
        word.setCommon(true);
        word.setSentence("The lion is known as the king of the jungle.");
        word.setActive(true);
        word.setLevel(2);

        wordRepository.save(word);

        // create and save a stageword linked to the word
        StageWord stageWord = new StageWord();
        stageWord.setId("sw001");
        stageWord.setStatus(Status.PENDING);
        stageWord.setListenedQty(0);
        stageWord.setLastUpdatedDateTime(new Date());
        stageWord.setWord(word);

        stageWordRepository.save(stageWord);

        // retrieve and validate stageword
        Optional<StageWord> retrievedStageWordOpt = stageWordRepository.findById(stageWord.getId());
        assertTrue(retrievedStageWordOpt.isPresent(), "StageWord should be present in repository");

        StageWord retrievedStageWord = retrievedStageWordOpt.get();

        // validate that the word in stageword is not null
        assertNotNull(retrievedStageWord.getWord(), "Word in StageWord should not be null");

        // validate that the word in StageWord is the specific word created
        assertEquals("Lion", retrievedStageWord.getWord().getText(), "Word linked to StageWord should be Lion");
    }
}
