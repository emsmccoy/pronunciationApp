package dev.pronunciationAppBack;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.pronunciationAppBack.model.User;
import dev.pronunciationAppBack.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@Transactional
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private User user;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll(); // Clean database before each test

        user = new User();
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setPassword("password123");

        userRepository.save(user);
    }

    @Test
    void testGetAllUsers() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].username").value("testuser"));
    }

    @Test
    void testGetUserById() throws Exception {
        mockMvc.perform(get("/api/users/" + user.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("testuser"));
    }

    @Test
    void testCreateUser() throws Exception {
        User newUser = new User();
        newUser.setUsername("newuser");
        newUser.setEmail("newuser@example.com");
        newUser.setPassword("securePass");

        mockMvc.perform(post("/api/users/createUser") // Perform a POST request to the specified endpoint
                        .contentType(MediaType.APPLICATION_JSON) // Set the request's content type to JSON
                        .content(objectMapper.writeValueAsString(newUser))) // Convert 'newUser' to a JSON string and send it as the request body
                .andExpect(status().isCreated()) // Expect the response status to be 201 CREATED
                .andExpect(jsonPath("$.username").value("newuser")); // Expect the JSON response to contain "username": "newuser"
    }



    @Test
    void testUpdateUser() throws Exception {
        user.setUsername("updateduser");

        mockMvc.perform(put("/api/users/" + user.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("updateduser"));
    }

    @Test
    void testDeleteUser() throws Exception {
        assertTrue(userRepository.existsById(user.getId()));

        mockMvc.perform(delete("/api/users/" + user.getId()))
                .andExpect(status().isOk());

        assertFalse(userRepository.existsById(user.getId()));
    }
}

