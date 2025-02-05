package dev.pronunciationAppBack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
//@Data // combines @Getter, @Setter, @ToString, @EqualsAndHashCode, and @RequiredArgsConstructor into a single annotation.
@Setter
@Getter
@Entity
@Table(name = "`USER`")
public class User {

    // @Getter
    // @Setter
    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @JsonProperty("username")
    // @Column(unique = true, nullable = false)
    private String username;

    @JsonProperty("email")
    // @Column(unique = true, nullable = false)
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("joinDate")
    private LocalDateTime joinDate;
    private boolean isActive;

    @PrePersist // call the annotated method before entity is persisted in db
    protected void onCreate(){
        joinDate = LocalDateTime.now();
    }

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

    public String getId() {
        return id;
    }


}
