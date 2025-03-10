package dev.pronunciationAppBack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Stage {

    @Id
    private String id;

    private String name;
    private String avatarUrl;
    private String status;
    private int progress;
    private int currentScore;
    private GameProgress gameProgress;
    private Level level;

    @OneToMany(mappedBy = "stage")
    private List<StageWord> stageWords;
}
