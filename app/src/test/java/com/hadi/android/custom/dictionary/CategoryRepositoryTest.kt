package com.hadi.android.custom.dictionary

import com.hadi.android.custom.dictionary.model.dao.CategoryDao
import com.hadi.android.custom.dictionary.doman.Category
import org.junit.After
import org.junit.Test
import org.junit.Assert.*

class CategoryRepositoryTest {

    private val testDatabase = TestObjectBoxDatabase()
    private var categoryDao: CategoryDao =
        CategoryDao(testDatabase.boxStore.boxFor(Category::class.java))

    @After
    fun tearDown(){
        testDatabase.close()
    }

    @Test
    fun insert_CategoryWithTitle_CategoryInserted() {
        val title = "Computer"
        val category =
            Category(title = title)
        val id: Long = categoryDao.insert(category)
        assertNotEquals(0, id)
        assertEquals(category.title, title)
        assertEquals(0, category.relatedWords.size)
    }

    @Test
    fun update_AlreadyExistedCategoryWithNewTitle_CategoryUpdated() {
        val oldTitle = "Computer"
        val oldCategory =
            Category(title = oldTitle)
        val id: Long = categoryDao.insert(oldCategory)

        val newCategory = categoryDao.getCategory(id)
        val newTitle = "Grammer"
        newCategory?.title = newTitle
        newCategory?.let { categoryDao.update(it) }

        val category = categoryDao.getCategory(id)
        assertEquals(newTitle, category?.title)
    }

    @Test
    fun remove_CategoryId_CategoryRemoved(){
        val title = "Computer"
        val category =
            Category(title = title)
        val id: Long = categoryDao.insert(category)
        assertTrue(id > 0)
        assertNotNull(categoryDao.getCategory(id))
        categoryDao.deleteWithAllWords(id)
        assertNull(categoryDao.getCategory(id))
    }

    @Test
    fun getAllCategories_NoParameters_AllCategoriesFetched(){
        val category1 =
            Category(title = "First")
        val category2 =
            Category(title = "Second")
        assertEquals(0, categoryDao.getAllCategories().size)
        categoryDao.insert(category1)
        categoryDao.insert(category2)
        assertEquals(2, categoryDao.getAllCategories().size)
    }

    @Test
    fun getCategory_CategoryId_CategoryFetched(){
        val category =
            Category(title = "First")
        assertNull(categoryDao.getCategory(1))
        categoryDao.insert(category)
        assertNotNull(categoryDao.getCategory(1))
    }

}