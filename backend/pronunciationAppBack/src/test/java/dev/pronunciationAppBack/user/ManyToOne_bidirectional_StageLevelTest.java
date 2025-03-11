package dev.pronunciationAppBack.user;

import dev.pronunciationAppBack.model.Level;
import dev.pronunciationAppBack.model.Stage;
import dev.pronunciationAppBack.repository.LevelRepository;
import dev.pronunciationAppBack.repository.StageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ManyToOne_bidirectional_StageLevelTest {

    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private LevelRepository levelRepository;

    @Test
    @Transactional
    void StageLevelRelationshipTest() {
        // Create and persist Level
        Level level = new Level();
        level.setId("level_1");
        level.setNumber(1);
        level.setName("Beginner");
        level.setRequiredScore(100);
        level.setBlocked(false);
        level.setWords(new ArrayList<>());
        level.setStages(new ArrayList<>());
        Level savedLevel = levelRepository.save(level);

        // Create and persist a stage object
        Stage stage = new Stage();
        stage.setId("st001");
        stage.setName("Test Stage");
        stage.setAvatarUrl("test-url");
        stage.setStatus("active");
        stage.setProgress(0);
        stage.setCurrentScore(0);
        stage.setGameProgress(null);
        stage.setLevel(savedLevel);
        Stage savedStage = stageRepository.save(stage);

        savedLevel.getStages().add(savedStage);
        levelRepository.save(savedLevel);

        assertNotNull(savedLevel.getStages(), "Level should have stages");
        assertFalse(savedLevel.getStages().isEmpty(), "The stages array should have at least one value");
        assertEquals(savedLevel.getId(), savedStage.getLevel().getId());
    }
}
