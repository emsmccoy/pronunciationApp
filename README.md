# PRA#02-SpringBoot: Create User API Rest

## CIFO La Violeta - FullStack IFCD0210-25 MF01

This document serves as a guide and log for the backend development of the PRA#02 Spring Boot project.

---

## PR Submission Checklist

### **Common Tasks:**

- [x] Create User @Entity
- [x] Create UserController (Rest API controller)
- [x] Implement UserRepository
- [x] Configure application properties with local H2 database
- [x] Develop UserService
- [x] Test all endpoints with Postman

### Optional Tasks:

- [x] Configure Postgres database
- [x] Implement Faker for test data
- [x] Add unit tests for services
- [x] Integration tests for controllers

### **Testing**:

- [x] All endpoints tested in Postman.
- [x] Error handling implemented in controllers.
- [x] Data persistence verified in H2 database.

---

## Estimated Time for Tasks

### Common Part

| Task                        | Estimated Time | Actual Time    | Impediments (if any)                                                      | New Concepts                                                                                                 |
| --------------------------- | -------------- | -------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------ |
| Create User @Entity         | 1 hours        | 45 min         |                                                                           | @PrePersist<br/>@GeneratedValue(strategy = GenerationType.UUID)<br/>@Column(unique = true, nullable = false) |
| Create UserController       | 1 hours        | 1.5 hour       |                                                                           | ResponseEntity utility methods <br/> Centralize headers handling using helper method                         |
| Implement UserRepository    | 0.5 hours      | 0.5 hours      |                                                                           |                                                                                                              |
| Configure H2 database       | 0.5 hours      | 0.5 hours      |                                                                           |                                                                                                              |
| Develop UserService         | 2 hours        | 1 hours        |                                                                           |                                                                                                              |
| Test endpoints with Postman | 1.5 hours      | 2 hours        | data.sql only executes correctly if the table has been created previously | data.sql to introduce mock data <br/>postman data file to test and run collections                           |
| **Total**                   | **6.5 hours**  | **6.25 hours** |                                                                           |                                                                                                              |

### Optional Part

| Task                              | Estimated Time | Actual Time   | Impediments (if any) | New Concepts                                                                                                                        |
| --------------------------------- | -------------- | ------------- | -------------------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| Configure Postgres database       | 2.5 hours      | 2.5 hours     |                      |                                                                                                                                     |
| Implement Faker for test data     | 1 hours        | 1.5 hours     |                      | Use Faker dinamically via API (not implemented) <br/> Streams: IntStream.range(x, y).mapToObj(i -> ...).collect(Collectors.toList() |
| Add unit tests for services       | 2 hours        | 1.5 hours     |                      | Mockito JUnit integration                                                                                                           |
| Integration tests for controllers | 2 hours        | 1 hour so far |                      | MockMvc and Fluent API                                                                                                              |
| **Total**                         | **7.5 hours**  | **6.5 hours** |                      |                                                                                                                                     |

---

## Images

### <u>H2</u>

#### Database Connection

![](./PRA/PRA02-H2.png)

#### Postman Runner Results

![](./PRA/PRA02-PostmanRunner.png)

### <u>Postgres</u>

#### Database Connection (pgAdmin 4 & terminal)

![](./PRA/PRA02-pgAdmin4.png)

![](/./PRA/PRA02-PostgresTerminal.png)

#### Postman Runner Results

![](./PRA/PRA02-PostmanRunner-Postgres.png)

---

## Future Improvements

- <mark>Implement Global Exception Handling.</mark>
- Add more unit and integration tests for key functionalities.
- Implement custom queries for enhanced user search.
- Optimize service layer for better performance and maintainability.
- Enhance validation for user input fields.

---
