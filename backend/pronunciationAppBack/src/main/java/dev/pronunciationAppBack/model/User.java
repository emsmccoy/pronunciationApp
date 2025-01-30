package dev.pronunciationAppBack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data // combines @Getter, @Setter, @ToString, @EqualsAndHashCode, and @RequiredArgsConstructor into a single annotation.
@Entity
@Table(name = "`USER`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private LocalDateTime joinDate;
    private boolean isActive;

    @PrePersist // call the annotated method before entity is persisted in db
    protected void onCreate(){
        joinDate = LocalDateTime.now();
    }

}
