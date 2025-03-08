package dev.pronunciationAppBack;

import dev.pronunciationAppBack.model.Category;
import dev.pronunciationAppBack.model.Word;
import dev.pronunciationAppBack.repository.CategoryRepository;
import dev.pronunciationAppBack.repository.WordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ManyToMany_WordCategoryTest {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Transactional
    void testWordCategoryRelationship() {


        // create category
        Category category = new Category();
        // set attributes
        category.setId("cat001");  // Set UUID manually
        category.setCategoryName("Animals");
        category.setSubCategoryName("Wild Animals");
        category.setDescription("Animals that live in the wild");
        category.setWordCount(0);

        // create word
        Word word = new Word();
        // set attributes
        word.setId("w001");
        word.setText("Lion");
        word.setDefinition("A large wild cat found in Africa and Asia");
        word.setPhoneticSpelling("ˈlaɪ.ən");
        word.setDifficulty(3);
        word.setCommon(true);
        word.setSentence("The lion is known as the king of the jungle.");
        word.setActive(true);
        word.setLevel(2);

        // save both in repository
        wordRepository.save(word);
        categoryRepository.save(category);

        // set word in category and the other way
        category.getWords().add(word);
        word.getCategories().add(category);

        wordRepository.save(word);
        categoryRepository.save(category);

        // check if word also has the category
        Optional<Word> retrievedWordOpt = wordRepository.findById(word.getId());
        assertTrue(retrievedWordOpt.isPresent(), "Word should be present in repo");

        Word retrievedWord = retrievedWordOpt.get();
        System.out.println(retrievedWord);

        assertNotNull(retrievedWord.getCategories(), "Categories should not be null");

        Set<Category> retrievedCategories = retrievedWord.getCategories();
        assertEquals(1, retrievedCategories.size(), "There should be one category linked to the word");
        assertEquals("Animals", retrievedCategories.iterator().next().getCategoryName(), "The name of the category should be Animals");

        Optional<Category> retrievedCategoryOpt = categoryRepository.findById(category.getId());
        assertTrue(retrievedCategoryOpt.isPresent(), "Category should be present in repo");

        Category retrievedCategory = retrievedCategoryOpt.get();
        assertNotNull(retrievedCategory.getWords(), "Words list should not be null");

        assertEquals("Lion", retrievedCategory.getWords().iterator().next().getText(), "The word linked to the category should be 'Lion'");
    }
}
