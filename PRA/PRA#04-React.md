# PRA#04-SpringBoot: JPA Relationships and Model Enhancement

## CIFO La Violeta - FullStack IFCD0210-25 MF01

In this practical exercise, you will enhance the **Spring Boot application from PRA#02**, focusing on implementing JPA relationships and improving the data model for the Pronunciation App.

## Objectives

The primary objectives of this practical exercise are to:

- <mark>Implement various JPA relationship</mark>s (One-to-One, One-to-Many, Many-to-Many)

- Enhance the existing data model based on the provided class diagram

- Configure proper JPA annotations for each relationship

- Implement <mark>bidirectional</mark> relationships where appropriate

- Create and configure <mark>join tables</mark> for Many-to-Many relationships

## Project Base

- Backend Repository: [PronunciationApp Backend](https://github.com/AlbertProfe/pronunciationApp/tree/backend-spring-boot/backend/pronunciationAppBack)

- JPA Resources: [JPA Resources](https://github.com/AlbertProfe/pronunciationApp/tree/backend-spring-boot/backend/resources/jpa)

- Model Resources: [Model Resources](https://github.com/AlbertProfe/pronunciationApp/tree/backend-spring-boot/backend/resources/jpa/model)

- CLI Spring Resources: [CLI Spring Resources](https://github.com/AlbertProfe/pronunciationApp/tree/backend-spring-boot/backend/resources/cli-spring)

- useBorrowBook sandbox: [GitHub - AlbertProfe/userBorrowBook](https://github.com/AlbertProfe/userBorrowBook)

## Tasks

Summary of tasks:

- Review and improve the model v0.2

- Implement` One-to-One` relationship between `UserApp` and `GameProgress`

- Create `Many-to-Many` relationship between `Word` and `Category`

- Implement `One-to-Many` and `Many-to-One `relationships for other entities

- Configure JPA annotations for all relationships

- Create necessary `repository interfaces`

- Implement basic service methods for each entity

- <mark>Test</mark> relationships with sample data

## Tasks Description

1. **Review and Improve Model v0.2**
   
   - Analyze the provided class diagram
   
   - Identify any potential improvements or missing relationships
   
   - Update the model if necessary

2. **Implement One-to-One: UserApp and GameProgress**
   
   - Create a bidirectional One-to-One relationship
   
   - Make UserApp the owning side of the relationship
   
   - Use appropriate JPA annotations (`@OneToOne`, `@JoinColumn`)

3. **Create Many-to-Many: Word and Category**
   
   - Implement a Many-to-Many relationship
   
   - Create a join table using `@JoinTable` annotation
   
   - Configure bidirectional mapping if needed

4. **Implement One-to-Many and Many-to-One Relationships**
   
   - Identify and implement all One-to-Many and Many-to-One relationships from the class diagram
   
   - Use appropriate annotations (`@OneToMany`,` @ManyToOne`)
   
   - Configure cascade types and fetch strategies as needed

5. **Configure JPA Annotations**
   
   - Ensure all entities have proper JPA annotations
   
   - Configure `@Id`, `@GeneratedValue` for primary keys
   
   - Use `@Column` annotations for specific column configurations

6. **Create Repository Interfaces**
   
   - Develop JpaRepository interfaces for each entity
   
   - Add custom query methods if required

7. **Implement Basic Service Methods**
   
   - Create service classes for each entity
   
   - Implement CRUD operations in the service layer

8. **Test Relationships**
   
   - Create a test class to populate the database with sample data
   
   - Verify that all relationships are working correctly
   
   - Test cascade operations and fetching strategies

## Code Samples

## One-to-One Relationship Example

```java
@Entity
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_progress_id", referencedColumnName = "id")
    private GameProgress gameProgress;

    // Other fields and methods
}

@Entity
public class GameProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "gameProgress")
    private UserApp userApp;

    // Other fields and methods
}

```

## Many-to-Many Relationship Example

```java
@Entity
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "word_category",
        joinColumns = @JoinColumn(name = "word_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    // Other fields and methods
}

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "categories")
    private Set<Word> words = new HashSet<>();

    // Other fields and methods
}

```

## Optional Enhancements

1. **Implement Data Auditing**
   
   - Use @CreatedDate, @LastModifiedDate, @CreatedBy, and @LastModifiedBy annotations
   
   - Configure AuditorAware for user auditing

2. **Add Validation**
   
   - Use Bean Validation annotations (@NotNull, @Size, etc.) in entity classes
   
   - Implement custom validation logic in service layer

3. **Implement Pagination and Sorting**
   
   - Use Spring Data JPA's Pageable interface in repository methods
   
   - Implement service methods that support pagination and sorting

4. **Create Custom Queries**
   
   - Implement complex queries using @Query annotation in repositories
   
   - Create native queries for performance-critical operations

## Submission Guidelines

- Fork the existing [PronunciationApp](https://github.com/AlbertProfe/pronunciationApp) repository and clone it to your local environment.

- Create a new branch named `PRA04-YourName` from the `backend-spring-boot` branch.

- Commit your changes with clear, descriptive messages.

- Push your branch to your forked repository.

- Create a pull request to the `AlbertProfe` repository with a summary of your changes, titled:
  
  - `PRA#04_SpringBoot-YourName-JPARelationships`

Good luck with your implementation! Focus on creating a well-structured data model with proper JPA relationships and annotations.
