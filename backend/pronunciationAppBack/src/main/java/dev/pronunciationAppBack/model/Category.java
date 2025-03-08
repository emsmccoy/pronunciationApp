package dev.pronunciationAppBack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {

    @Id
    private String id;
    private String categoryName;
    private String subCategoryName;
    private String description;
    private int wordCount;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "WORD_CATEGORY_JOIN_TABLE",
            joinColumns = @JoinColumn(name = "WORD_FK"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_FK"))
    private Set<Word> words = new HashSet<>();
}
