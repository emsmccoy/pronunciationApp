package dev.pronunciationAppBack.utilities;

import net.datafaker.Faker;
import dev.pronunciationAppBack.model.UserApp;
import dev.pronunciationAppBack.repository.UserAppRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component // This ensures it runs at startup
public class DataInitializer implements CommandLineRunner {

    private final UserAppRepository userRepository;
    private final Faker faker = new Faker();

    public DataInitializer(UserAppRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public void run(String... args) {
//        if (userRepository.count() == 0) { // Prevent duplicate inserts
//            List<User> users = new ArrayList<>();
//            for (int i = 0; i < 10; i++) {
//                User user = new User();
//                user.setId(faker.internet().uuid()); // Explicit UUID
//                user.setUsername(faker.name().username());
//                user.setEmail(faker.internet().emailAddress());
//                user.setPassword(faker.internet().password());
//                user.setJoinDate(faker.date().birthday().toInstant()
//                        .atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
//                user.setActive(faker.bool().bool());
//
//                users.add(user);
//            }
//            userRepository.saveAll(users);
//        }
//    }

    // streams version
    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) { // Prevent duplicate inserts
            List<UserApp> users = IntStream.range(0, 10) //create an int stream
                    .mapToObj(i -> new UserApp( //transforms int into object
                            faker.internet().uuid(),  // Explicit UUID
                            faker.name().username(),
                            faker.internet().emailAddress(),
                            faker.internet().password(),
                            faker.timeAndDate().birthday().atStartOfDay(),
                            faker.bool().bool(),
                            null
                    ))
                    .collect(Collectors.toList()); //collects objects to list

            userRepository.saveAll(users);
        }
    }

}

