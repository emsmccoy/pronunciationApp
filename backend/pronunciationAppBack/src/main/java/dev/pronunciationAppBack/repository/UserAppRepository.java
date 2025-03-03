package dev.pronunciationAppBack.repository;

import dev.pronunciationAppBack.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppRepository extends JpaRepository<UserApp, String> {
    UserApp getUserById(String id);
}
