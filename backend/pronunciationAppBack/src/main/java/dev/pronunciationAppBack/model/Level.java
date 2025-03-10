package dev.pronunciationAppBack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Level {

    @Id
    private String id;
    private int number;
    private String name;
    private int requiredScore;
    private boolean isBlocked;

    @OneToMany(mappedBy = "level")
    private List<Word> words = new ArrayList<>();

    @OneToMany(mappedBy = "level")
    private List<Stage> stages = new ArrayList<>();
}
