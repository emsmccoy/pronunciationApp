# PronunciationApp Backend v0.3

## JPA References

- [Spring Boot: Data &amp; DB – albertprofe wiki](https://albertprofe.dev/springboot/boot-concepts-data.html)

- [Spring Boot: JPA &amp; DI – albertprofe wiki](https://albertprofe.dev/springboot/boot-concepts-jpa.html)

- [Spring Boot: JPA Mappings – albertprofe wiki](https://albertprofe.dev/springboot/boot-concepts-jpa-2.html)

- [Spring Boot: JPA Relationships – albertprofe wiki](https://albertprofe.dev/springboot/boot-concepts-jpa-3.html)

- [Spring Boot: JPA Queries – albertprofe wiki](https://albertprofe.dev/springboot/boot-concepts-jpa-4.html)

- [Spring Boot: JPA Inherence – albertprofe wiki](https://albertprofe.dev/springboot/boot-concepts-jpa-5.html)

- [Spring Boot: Scaling – albertprofe wiki](https://albertprofe.dev/springboot/boot-concepts-scaling.html)

### Summary

JPA stands for `Java Persistence API`.

It is a Java specification for **managing, persisting, and accessing relational data** in Java applications.

JPA is a **standard API for ORM (Object-Relational Mapping)** and provides a way to map Java objects to relational databases

## Word 1:n Pronunciation

**Step 1: Define the Relationship**

> We must to identify the relationship as One-to-Many: one Word can have multiple Pronunciations, and each Pronunciation belongs to a unique Word.

**Step 2: Choose the Annotations**

We need to  use `@OneToMany` in the `Word` entity and `@ManyToOne` in the `Pronunciation` entity.

**Step 3: Use @JoinColumn**

The `@JoinColumn` annotation is <mark>key for specifying the foreign key</mark> **column** in the `Pronunciation` table

**Step 4: Configure the Annotations**

We can configure the annotations for better performance and consistency:

In the `Word` class:

```java
@OneToMany(mappedBy = "word", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<Pronunciation> pronunciations = new ArrayList<>();
```

In the `Pronunciation` class:

```java
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "WORD_ID_FK", nullable = false)
private Word word;
```

- `cascade = CascadeType.ALL` ensures that operations on Word are cascaded to associated Pronunciations.
- `fetch = FetchType.LAZY` improves performance by loading related entities only when accessed.
- `nullable = false` ensures that every Pronunciation must be associated with a Word.

## Test JUnit

### With @SpringBootTest

Test Class Overview:

- Uses `@SpringBootTest` annotation, which loads the full application context for testing.
- Autowires `WordRepository` and `PronunciationRepository` for database operations.

<mark>Test Method: AssignTestWord</mark>

1. Creates a new `Pronunciation` object and sets its properties.
2. Saves the `Pronunciation` object to the database.
3. Attempts to find a `Word` by ID "8f7d1b9e3a2c5f6e".
4. If the `Word` is found:
   - Associates the `Pronunciation` with the found `Word`.
   - Saves the updated `Pronunciation` to the database.

**Key Points**

- The test doesn't create a new `Word`, it assumes one exists with ID "8f7d1b9e3a2c5f6e".
- There are no assertions to verify the test results.
- The test demonstrates how to associate a `Pronunciation` with an existing `Word`.
- Commented code suggests alternative approaches that were not implemented.

**Potential Improvements**

- Add assertions to verify the relationship is correctly established.
- Create a `Word` object if it doesn't exist to ensure test consistency.
- Use `@DataJpaTest` for more focused repository testing.
- Add error handling for cases where the `Word` is not found.

```java
@SpringBootTest
public class PronunciationTest {

    @Autowired
    WordRepository wordRepository;
    @Autowired
    PronunciationRepository pronunciationRepository;

    @Test
    public void AssignTestWord(){

        // New Pronunciation object
        Pronunciation p1 = new Pronunciation();
        p1.setId("1");
        p1.setAudioDescription("test");
        p1.setAudioDuration(1);
        p1.setAudioSize(1);
        p1.setAudioUrl("test");
        p1.setDefinition("test");
        p1.setPhoneticSpelling("test");
        p1.setSpeakerGender("test");
        p1.setType(Pronunciation.type.SAMPLE);

        pronunciationRepository.save(p1);

        // get word by id from repository
        // by JPA repository by id returning optional container Word/Null
        Optional<Word> optionalWord  =  wordRepository.findById("8f7d1b9e3a2c5f6e");
        System.out.println(optionalWord);

        if  (optionalWord.isPresent()) {
            // get word from optional container
            p1.setWord(optionalWord.get());
            pronunciationRepository.save(p1);
        }

    }
}
```

### With @DataJpaTest

Our test case is a good start, but there are a few improvements we can make:

1. Use `@DataJpaTest` instead of `@SpringBootTest` for repository tests to load only JPA-related components.
2. Use `@Transactional` to ensure each test runs in its own transaction.
3. Add assertions to verify the relationship is correctly established.

Here's an improved version of our test:

```java
@DataJpaTest
@Transactional
public class PronunciationTest {

    @Autowired
    WordRepository wordRepository;
    @Autowired
    PronunciationRepository pronunciationRepository;

    @Test
    public void testAssignPronunciationToWord() {
        // Create and save a Word
        Word word = new Word();
        word.setId("8f7d1b9e3a2c5f6e");
        word.setWordName("Test");
        wordRepository.save(word);

        // Create and save a Pronunciation
        Pronunciation pronunciation = new Pronunciation();
        pronunciation.setId("1");
        pronunciation.setAudioDescription("test");
        // ... set other fields ...
        pronunciation.setWord(word);
        pronunciationRepository.save(pronunciation);

        // Verify the relationship
        Optional<Word> retrievedWord = wordRepository.findById("8f7d1b9e3a2c5f6e");
        assertThat(retrievedWord).isPresent();
        assertThat(retrievedWord.get().getPronunciations()).hasSize(1);
        assertThat(retrievedWord.get().getPronunciations().get(0).getId()).isEqualTo("1");

        Optional<Pronunciation> retrievedPronunciation = pronunciationRepository.findById("1");
        assertThat(retrievedPronunciation).isPresent();
        assertThat(retrievedPronunciation.get().getWord().getId()).isEqualTo("8f7d1b9e3a2c5f6e");
    }
}
```

### Postman Usage

To test this relationship using Postman:

1. Create a POST endpoint to create a Word.
2. Create another POST endpoint to create a Pronunciation and associate it with a Word.
3. Create a GET endpoint to retrieve a Word with its associated Pronunciations.

Example Postman requests:

1. Create Word:
   POST /api/words
   
   ```json
   {
     "id": "8f7d1b9e3a2c5f6e",
     "wordName": "Example",
     "definition": "An instance serving to illustrate"
   }
   ```

2. Create Pronunciation:
   POST /api/pronunciations
   
   ```json
   {
     "id": "1",
     "audioDescription": "Example pronunciation",
     "word": {
       "id": "8f7d1b9e3a2c5f6e"
     }
   }
   ```

3. Retrieve Word with Pronunciations:
   GET /api/words/8f7d1b9e3a2c5f6e

#### Our example

```json
{
  "id": "8f7d1b9e3a2c5f6e",
  "wordName": "aberration",
  "definition": "a departure from what is normal, usual, or expected",
  "phoneticSpelling": "ˌæbəˈreɪʃən",
  "sentence": "The sudden drop in temperature was an aberration for this time of year.",
  "level": 3,
  "pronunciations": [
    {
      "id": "1",
      "audioDescription": "test",
      "audioDuration": 1,
      "audioSize": 1,
      "audioUrl": "test",
      "definition": "test",
      "phoneticSpelling": "test",
      "speakerGender": "test",
      "type": "SAMPLE"
    }
  ],
  "active": true
```
