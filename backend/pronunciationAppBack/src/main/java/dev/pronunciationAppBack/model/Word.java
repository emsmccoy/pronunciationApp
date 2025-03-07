package dev.pronunciationAppBack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Word {

    @Id
    private String id;
    private String text;
    private String definition;
    private String phoneticSpelling;
    private int difficulty;
    private boolean isCommon;
    private String sentence;
    private boolean isActive;
    private int level;

    @OneToMany(mappedBy = "word")
    private List<Pronunciation> pronunciations;

    @JsonIgnore
    @ManyToMany(mappedBy = "words")
    private Set<Category> categories;

    @Override
    public String toString() {
        return "Word{" +
                "id='" + id + '\'' +
                ", wordName='" + text + '\'' +
                ", definition='" + definition + '\'' +
                ", phoneticSpelling='" + phoneticSpelling + '\'' +
                ", sentence='" + sentence + '\'' +
                ", isActive=" + isActive +
                ", level=" + level +
                '}';
    }
}
