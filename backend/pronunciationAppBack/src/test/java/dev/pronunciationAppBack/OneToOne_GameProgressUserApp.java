package dev.pronunciationAppBack;


import dev.pronunciationAppBack.model.GameProgress;
import dev.pronunciationAppBack.model.GameStage;
import dev.pronunciationAppBack.model.UserApp;
import dev.pronunciationAppBack.repository.GameProgressRepository;
import dev.pronunciationAppBack.repository.UserAppRepository;
import org.h2.engine.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
public class OneToOne_GameProgressUserApp {

    @Autowired
    private UserAppRepository userAppRepository;

    @Autowired
    private GameProgressRepository gameProgressRepository;

    @Test
    void testUserAppGameProgressRelationship(){

        //GameProgress object
        GameProgress gameProgress = new GameProgress();

        gameProgress.setCurrentScore(100);
        gameProgress.setCurrentStage(GameStage.LEVEL_1);
        gameProgress.setLastPlayedDate(LocalDateTime.now());
        gameProgress.setWordsLearned(50);

        //UserApp object

        UserApp user = new UserApp();
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setPassword("securepassword");
        user.setActive(true);
        user.setGameProgress(gameProgress);

        //Persist UserApp (cascade ALL allows GameProgress to be saved automatically)
        userAppRepository.save(user);

        //Retrieve from DB and verify
        Optional<UserApp> retrievedUserOpt = userAppRepository.findById(user.getId());
        assertTrue(retrievedUserOpt.isPresent());
        UserApp retrievedUser = retrievedUserOpt.get();
        System.out.println(retrievedUser);

        assertNotNull(retrievedUser.getGameProgress());
        assertEquals(100, retrievedUser.getGameProgress().getCurrentScore());
        assertEquals(50, retrievedUser.getGameProgress().getWordsLearned());
    }
}
