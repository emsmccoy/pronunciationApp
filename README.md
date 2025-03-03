# PRA#04-SpringBoot: JPA Relationships and Model Enhancement

## Overview

This document serves as a guide and log for the frontend development of the PRA#04-SpringBoot project. The exercise focuses on implementing JPA relationships and enhancing the data model for a Spring Boot pronunciation application.

---

## UML Model

```mermaid
classDiagram
    class User {
        +String id
        +String usrname
        +int age
        +String email
        +int totalScore
        +boolean isActive
    }
    class Word {
        +String id
        +String text
        +String description
        +String sentence
        +int difficulty
        +boolean isCommon
    }
    class Pronunciation {
        +String id
        +String audioName
        +int audioSize
        +String audioUrl
        +String phoneticSpelling
        +String speakerGender
        +enum type  // canonical, recorded 
    }
    class Level {
        +String id
        +int number
        +String name
        +int requiredScore
        +boolean isBlocked
    }
    class Category {
        +String id
        +String categoryName
        +String subCategoryName
        +String description
        +int wordCount
    }
    class GameProgress {
        +String id
        +int currentScore
        +enum currentStage  // stage_01, stage_02 
        +Date lastPlayedDate
        +int wordsLearned
    }
    class Stage {
        +String id
        +String name
        +String avatarUrl
        +String status
        +int progress
        +int currentScore
    }
    class StageWord {
        +String id
        +enum status  // done, pending, fail 
        +Date lastUpdatedDateTime
    }


    User "1" -- "1" GameProgress : tracks progress
    Word "1" -- "*" Pronunciation : has pronunciation
    Word "*" -- "*" Category : belongs to multiple
    Word "*" -- "1" Level : has level
    GameProgress "1" -- "*" Stage : is at stage
    Stage "*" -- "1" Level : has level
    Stage "1" -- "*" StageWord : has tracked words
    Word "1" -- "*" StageWord : has stageword
```

## PR Submission Checklist

### **Completed Tasks**:

- [x]  Review and Improve Model v0.2
- [ ]  Implement One-to-One: UserApp and GameProgress  
- [ ]  Create Many-to-Many: Word and Category
- [ ]  Implement One-to-Many/Many-to-One Relationships
- [ ]  Configure JPA Annotations
- [ ]  Create Repository Interfaces
- [ ]  Implement Basic Service Methods
- [ ]  Test Relationships
- [ ]  Data Auditing
- [ ]  Advanced Validation
- [ ]  Pagination and Sorting Support
- [ ]  Custom Query Optimization

### **Testing**:

- [ ] Relationship integrity tests
- [ ] Cascade operation tests
- [ ] Fetch strategy validation

---

## Estimated Time for Tasks

### Common Part

| Task                                   | Estimated Time | Actual Time | Impediments | New Concepts             |
| -------------------------------------- | -------------- | ----------- | ----------- | ------------------------ |
| Model Review                           | 15 min         | 10 min      |             | JPA mapping              |
| One-to-One (User-App and GameProgress) | 15 min         |             |             | Bidirectional mapping    |
| Many-to-Many (Word - Category)         | 15 min         |             |             | Join Table configuration |
| One-to-Many & Many-to-One              | 1:30 hours     |             |             |                          |
| Relationship Configuration             | 1 hour         |             |             | Cascade types            |
| Repository Creation                    | 10 min         |             |             | Spring Data JPA          |
| Service Implementation                 | 1 hour         |             |             | Service layer patterns   |
| Testing                                | 2 hours        |             |             | Data integrity checks    |
| **Total**                              | **6:30 hours** |             |             |                          |

### Optional Part

| Task                   | Estimated Time | Actual Time | Impediments | New Concepts        |
| ---------------------- | -------------- | ----------- | ----------- | ------------------- |
| Data Auditing          | 1 hours        |             |             | JPA Auditing        |
| Advanced Validation    | 1:20 hours     |             |             | Bean Validation     |
| Pagination and sorting | 2 hours        |             |             | Pageable interface  |
| Custom Queries         | 1 hour         |             |             | JPQL/Native queries |
| **Total**              | **5:20 hours** |             |             |                     |

---

## Error Documentation and Solutions

### Error: `[ERROR_MESSAGE]`

**Corresponding Task:** [RELATED_TASK]

**Description:** [ERROR_DESCRIPTION]

**Error Trace:**

- **Component:** [COMPONENT_NAME]
- **File:** [FILE_NAME]
- **Line:** [ERROR_LINE]
- **Stack Trace:**
  - [ERROR_TRACE]

**Possible Causes:**

- [POTENTIAL_CAUSES]

**Solution:**

```jsx
// Fixed code or solution
```

**Explanation:** [EXPLANATION_OF_THE_SOLUTION]

---

## Future Improvements

- **Caching Mechanism** - Add Hibernate second-level cache configuration
