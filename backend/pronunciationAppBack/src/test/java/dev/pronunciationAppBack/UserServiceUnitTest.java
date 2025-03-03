package dev.pronunciationAppBack;

import net.datafaker.Faker;
import dev.pronunciationAppBack.model.UserApp;
import dev.pronunciationAppBack.repository.UserAppRepository;
import dev.pronunciationAppBack.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest {

    @Mock
    private UserAppRepository userRepository;

    @InjectMocks
    private UserService userService;

    private List<UserApp> mockUsers;
    private Faker faker = new Faker();

    @BeforeEach
    void setUp() {
        mockUsers = IntStream.range(0, 10)
                .mapToObj(i -> new UserApp(
                        String.valueOf(i + 1), // ID as String
                        faker.name().username(),
                        faker.internet().emailAddress(),
                        faker.internet().password(),
                        LocalDateTime.now(),
                        faker.bool().bool(),
                        null
                ))
                .collect(Collectors.toList());
    }

    @Test
    void testCreateUser() {
        UserApp user = mockUsers.get(0);
        when(userRepository.save(any(UserApp.class))).thenReturn(user);

        UserApp createdUser = userService.createUser(user);

        assertNotNull(createdUser); // user is not empty
        assertEquals(user.getUsername(), createdUser.getUsername()); //they have the same username
        verify(userRepository, times(1)).save(user); // userRepository's method save() is called once
    }

    @Test
    void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(mockUsers);

        List<UserApp> retrievedUsers = userService.getAllUsers();

        assertFalse(retrievedUsers.isEmpty()); //list is not empty
        assertEquals(mockUsers.size(), retrievedUsers.size()); //size of lists is the same
        verify(userRepository, times(1)).findAll(); //method findAll() runs once
    }

    @Test
    void testGetUserById() {
        UserApp user = mockUsers.get(0);
        when(userRepository.getUserById(user.getId())).thenReturn(user);

        Optional<UserApp> retrievedUser = userService.getUserById(user.getId());

        assertTrue(retrievedUser.isPresent()); // user exists
        assertEquals(user.getUsername(), retrievedUser.get().getUsername()); // username from mock and service is the same
        verify(userRepository, times(1)).getUserById(user.getId()); // method runs once
    }

    @Test
    void testUpdateUser() {
        UserApp user = mockUsers.get(0);
        when(userRepository.save(any(UserApp.class))).thenReturn(user);

        UserApp updatedUser = userService.updateUser(user);

        assertNotNull(updatedUser); // user is not null
        assertEquals(user.getUsername(), updatedUser.getUsername()); // username from mock and service are the same
        verify(userRepository, times(1)).save(user); // method runs
    }

    @Test
    void testDeleteUser() {
        String userId = mockUsers.get(0).getId();
        doNothing().when(userRepository).deleteById(userId); // no need for a mock response from repository

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteById(userId); // method runs
    }

    @Test
    void testDeleteAllUsers() {
        doNothing().when(userRepository).deleteAll();

        userService.deleteAllUsers();

        verify(userRepository, times(1)).deleteAll();
    }

    @Test
    void testExistsById() {
        String userId = mockUsers.get(0).getId();
        when(userRepository.existsById(userId)).thenReturn(true);

        boolean exists = userService.existsById(userId);

        assertTrue(exists);
        verify(userRepository, times(1)).existsById(userId);
    }

    @Test
    void testGetUserCount() {
        when(userRepository.count()).thenReturn((long) mockUsers.size());

        long count = userService.getUserCount();

        assertEquals(mockUsers.size(), count); // check mock and service lists are the same size
        verify(userRepository, times(1)).count();
    }
}
