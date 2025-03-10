package dev.pronunciationAppBack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameProgress {

    @Id
    private String id;
    private  int currentScore;
    @Enumerated(EnumType.STRING) //saves the enum name in the database
    private GameStage currentStage;
    private LocalDateTime lastPlayedDate;
    private int wordsLearned;

    @OneToOne(mappedBy = "gameProgress")
    private UserApp user;

    @OneToMany (mappedBy = "gameProgress")
    private List<Stage> stages = new ArrayList<>();
}
