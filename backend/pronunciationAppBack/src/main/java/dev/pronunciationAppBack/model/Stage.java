package dev.pronunciationAppBack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "GAME_PROGRESS_ID")
    private GameProgress gameProgress;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "LEVEL_ID")
    private Level level;

    @OneToMany(mappedBy = "stage")
    private List<StageWord> stageWords = new ArrayList<>();
}
