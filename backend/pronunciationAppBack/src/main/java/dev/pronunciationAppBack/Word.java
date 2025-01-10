package dev.pronunciationAppBack;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Word {

    private String id;
    private String wordName;
    private String definition;
    private String phoneticSpelling;
    private String sentence;
    private boolean isActive;
    private int level;


}
