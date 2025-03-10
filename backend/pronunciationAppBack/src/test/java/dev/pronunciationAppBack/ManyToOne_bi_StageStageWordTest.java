import dev.pronunciationAppBack.model.Stage;
import dev.pronunciationAppBack.model.StageWord;
import dev.pronunciationAppBack.model.Status;
import dev.pronunciationAppBack.repository.StageRepository;
import dev.pronunciationAppBack.repository.StageWordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ManyToOne_bi_StageStageWordTest {

    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private StageWordRepository stageWordRepository;

    @Test
    void StageStageWordRelationshipTest() {
        // Create a stage object
        Stage stage = new Stage();
        stage.setName("Test Stage");
        stage.setAvatarUrl("test-url");
        stage.setStatus("active");
        stage.setProgress(0);
        stage.setCurrentScore(0);
        stage.setGameProgress(null);
        stage.setLevel(null);

        // Save the stage object in the repository
        Stage savedStage = stageRepository.save(stage);

        // Create a StageWord object
        StageWord stageWord = new StageWord();
        stageWord.setStatus(Status.PENDING);
        stageWord.setLastUpdatedDateTime(new Date());
        stageWord.setStage(savedStage);

        // Save the StageWord in the repository
        StageWord savedStageWord = stageWordRepository.save(stageWord);

        // Assert that both stage and stageWord attributes are not null
        assertNotNull(savedStageWord.getStage());
        assertNotNull(savedStageWord);

        // Assert equals for specific values
        assertEquals(savedStage.getId(), savedStageWord.getStage().getId());
    }
}
