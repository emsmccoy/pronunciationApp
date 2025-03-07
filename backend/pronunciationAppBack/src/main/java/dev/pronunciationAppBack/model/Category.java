package dev.pronunciationAppBack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.Set;

public class Category {
    private String id;
    private String categoryName;
    private String subCategoryName;
    private String description;
    private int wordCount;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "WORD_CATEGORY_JOIN_TABLE",
            joinColumns = @JoinColumn(name = "WORD_FK"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_FK"))
    private Set<Word> words;
}
