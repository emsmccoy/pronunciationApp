# PRA#02-SpringBoot: Create User API Rest

## CIFO La Violeta - FullStack IFCD0210-25 MF01

This document serves as a guide and log for the backend development of the PRA#02 Spring Boot project.

---

## PR Submission Checklist

### **Common Tasks:**

- [x] Create User @Entity
- [ ] Create UserController (Rest API controller)
- [ ] Implement UserRepository
- [ ] Configure application properties with local H2 database
- [ ] Develop UserService
- [ ] Test all endpoints with Postman

### Optional Tasks:

- [ ] Configure Postgres database
- [ ] Implement Faker for test data
- [ ] Add unit tests for services
- [ ] Integration tests for controllers

### **Testing**:

- [ ] All endpoints tested in Postman.
- [ ] Error handling implemented in controllers.
- [ ] Data persistence verified in H2 database.

---

## Estimated Time for Tasks

### Common Part

| Task                     | Estimated Time | Actual Time | Impediments (if any) | New Concepts                                                                                                 |
| ------------------------ | -------------- | ----------- | -------------------- | ------------------------------------------------------------------------------------------------------------ |
| Create User @Entity      | 1 hours        | 45 min      |                      | @PrePersist<br/>@GeneratedValue(strategy = GenerationType.UUID)<br/>@Column(unique = true, nullable = false) |
| Create UserController    | 1 hours        | X hours     |                      |                                                                                                              |
| Implement UserRepository | 0.5 hours      | X hours     |                      |                                                                                                              |
| Configure H2 database    | 0.5 hours      | X hours     |                      |                                                                                                              |
| Develop UserService      | 2 hours        | X hours     |                      |                                                                                                              |

### Optional Part

| Task                              | Estimated Time | Actual Time | Impediments (if any) |
| --------------------------------- | -------------- | ----------- | -------------------- |
| Configure Postgres database       | 2.5 hours      | X hours     |                      |
| Implement Faker for test data     | 1 hours        | X hours     |                      |
| Add unit tests for services       | 2 hours        | X hours     |                      |
| Integration tests for controllers | 2 hours        | X hours     |                      |
| **Total**                         | **7.5 hours**  | **X hours** |                      |

---

## Error Documentation and Solutions

### Error: `[ERROR_MESSAGE]`

**Corresponding Task:** [RELATED_TASK]

**Description:** [ERROR_DESCRIPTION]

**Error Trace:**

- **Class:** [CLASS_NAME]
- **File:** [FILE_NAME]
- **Line:** [ERROR_LINE]
- **Stack Trace:**
  - [ERROR_TRACE]

**Possible Causes:**

- [POTENTIAL_CAUSES]

**Solution:**

```java
// Fixed code or solution
```

**Explanation:** [EXPLANATION_OF_THE_SOLUTION]

---

## Future Improvements

- Implement Global Exception Handling.
- Add more unit and integration tests for key functionalities.
- Implement custom queries for enhanced user search.
- Optimize service layer for better performance and maintainability.
- Enhance validation for user input fields.

---
