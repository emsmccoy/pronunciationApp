package dev.pronunciationAppBack;

import dev.pronunciationAppBack.model.GameProgress;
import dev.pronunciationAppBack.model.GameStage;
import dev.pronunciationAppBack.model.Stage;
import dev.pronunciationAppBack.repository.GameProgressRepository;
import dev.pronunciationAppBack.repository.StageRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ManyToOne_bidirectional_GameProgressStageTest {

    @Autowired
    private GameProgressRepository gameProgressRepository;

    @Autowired
    private StageRepository stageRepository;

    @Test
    @Transactional
    void testGameProgressStageRelationship() {
        // Create and persist GameProgress
        GameProgress gameProgress = new GameProgress();
        gameProgress.setId("gp1");
        gameProgress.setCurrentScore(100);
        gameProgress.setCurrentStage(GameStage.LEVEL_2);
        gameProgress.setLastPlayedDate(LocalDateTime.now());
        gameProgress.setWordsLearned(50);
        gameProgress.setStages(new ArrayList<>());
        gameProgressRepository.save(gameProgress);

        // Create and persist Stage
        Stage stage = new Stage();
        stage.setId("stage1");
        stage.setName("First Stage");
        stage.setAvatarUrl("/avatars/stage1.png");
        stage.setStatus("ACTIVE");
        stage.setProgress(25);
        stage.setCurrentScore(75);
        stage.setGameProgress(gameProgress);
        stage.setLevel(null);
        stageRepository.save(stage);

        // Add stage to gameProgress
        gameProgress.getStages().add(stage);

        gameProgressRepository.save(gameProgress);

        // Verify relationship from GameProgress side
        GameProgress retrievedGP = gameProgressRepository.findById("gp1")
                .orElseThrow(() -> new AssertionError("GameProgress not found"));

        assertNotNull(retrievedGP.getStages(), "Stages list should not be null");
        assertFalse(retrievedGP.getStages().isEmpty(), "GameProgress should have associated stages");
        assertEquals(1, retrievedGP.getStages().size(), "Incorrect number of stages");
        assertEquals("stage1", retrievedGP.getStages().get(0).getId(),
                "Stage ID mismatch in GameProgress relationship");

        // Verify relationship from Stage side
        Stage retrievedStage = stageRepository.findById("stage1")
                .orElseThrow(() -> new AssertionError("Stage not found"));

        assertNotNull(retrievedStage.getGameProgress(), "Stage should reference GameProgress");
        assertEquals("gp1", retrievedStage.getGameProgress().getId(),
                "GameProgress ID mismatch in Stage relationship");
    }
}

