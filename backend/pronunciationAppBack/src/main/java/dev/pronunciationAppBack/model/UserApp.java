package dev.pronunciationAppBack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data // combines @Getter, @Setter, @ToString, @EqualsAndHashCode, and @RequiredArgsConstructor into a single annotation.
@Entity
public class UserApp {

    // @Getter
    // @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // @Column(unique = true, nullable = false)
    private String username;

    // @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private LocalDateTime joinDate;
    private boolean isActive;

    @PrePersist // call the annotated method before entity is persisted in db
    protected void onCreate(){
        joinDate = LocalDateTime.now();
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GAME_PROGRESS_FK")
    private GameProgress gameProgress;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", joinDate=" + joinDate +
                ", isActive=" + isActive +
                '}';
    }

}
