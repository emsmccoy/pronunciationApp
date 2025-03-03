package dev.pronunciationAppBack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class GameProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private  int currentScore;
    private EnumType currentStage;
    private LocalDateTime lastPlayedDate;
    private int wordsLearned;
}
