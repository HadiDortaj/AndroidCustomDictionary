package com.hadi.android.custom.dictionary

import com.hadi.android.custom.dictionary.model.dao.WordDao
import com.hadi.android.custom.dictionary.model.entity.*
import org.junit.After
import org.junit.Test
import org.junit.Assert.*

class WordDaoTest {

    private val testDatabase = TestObjectBoxDatabase()
    private var wordDao: WordDao =
        WordDao(testDatabase.boxStore.boxFor(Word::class.java), testDatabase.boxStore.boxFor(Definition::class.java))

    @After
    fun tearDown() {
        testDatabase.close()
    }

    @Test
    fun insert_WordWithTitle_InsertedWordIdReturned() {
        val word = Word(title = "Buy")
        val id = wordDao.insert(word)
        assertNotEquals(0, id)
    }

    @Test
    fun getWord_InsertedWordId_WordReturned() {
        val word = Word(title = "Buy")
        val id = wordDao.insert(word)
        val insertedWord = wordDao.getWord(id)
        assertNotNull(insertedWord)
        assertEquals(id, insertedWord?.id)
    }

    @Test
    fun insert_WordWithTitleAndDefinition_WordAndItsDefinitionsInserted() {
        val word = Word(title = "Buy")
        val definition = Definition(definitionText = "to get something by paying for it")
        val type = Type(title = "verb")
        definition.type.target = type
        word.definitions.add(definition)
        val id = wordDao.insert(word)
        assertNotEquals(0, id)
        val insertedWord = wordDao.getWord(id)
        assertNotNull(insertedWord)
        insertedWord?.let {
            assertEquals("Buy", it.title)
            assertNotNull(it.definitions)
            assertEquals("verb", it.definitions[0].type.target.title)
            assertEquals("to get something by paying for it", it.definitions[0].definitionText)
        }
    }

    @Test
    fun insert_WordWithTitleAndDefinitionAndExample_WordAndItsDefinitionsAndExamplesInserted() {
        val word = Word(title = "Buy")
        val definition = Definition(definitionText = "to get something by paying for it")
        val type = Type(title = "verb")
        val example = Example(
            originalExample = "this is example origin text",
            translationOrExtraInformation = "translated text"
        )
        definition.type.target = type
        definition.examples.add(example)
        word.definitions.add(definition)
        val id = wordDao.insert(word)
        assertNotEquals(0, id)
        val insertedWord = wordDao.getWord(id)
        assertNotNull(insertedWord)
        insertedWord?.let {
            assertEquals("Buy", it.title)
            assertNotNull(it.definitions)
            assertEquals("verb", it.definitions[0].type.target.title)
            assertEquals("to get something by paying for it", it.definitions[0].definitionText)
            assertEquals(
                "this is example origin text",
                it.definitions[0].examples[0].originalExample
            )
            assertEquals(
                "translated text",
                it.definitions[0].examples[0].translationOrExtraInformation
            )
        }
    }

    @Test
    fun update_changedTitleWord_WordUpdatedWithNewTitle() {
        val word = Word(title = "Buy")
        val id = wordDao.insert(word)
        assertNotEquals(0, id)
        val fetchedWord = wordDao.getWord(id)
        assertNotNull(fetchedWord)
        fetchedWord?.let {
            assertEquals("Buy", fetchedWord.title)
            fetchedWord.title = "See"
            wordDao.update(fetchedWord)
            val updatedWord = wordDao.getWord(id)
            assertNotNull(updatedWord)
            updatedWord?.let {
                assertEquals("See", it.title)
            }
        }
    }

}