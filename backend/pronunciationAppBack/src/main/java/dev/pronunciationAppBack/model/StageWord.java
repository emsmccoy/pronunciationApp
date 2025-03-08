package dev.pronunciationAppBack.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class StageWord {

    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private Status status;
    private int listenedQty;
    private Date lastUpdatedDateTime;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "WORD_ID")
    private Word word;

}
