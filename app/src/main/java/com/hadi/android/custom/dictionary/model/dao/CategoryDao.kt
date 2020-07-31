package com.hadi.android.custom.dictionary.model.dao

import com.hadi.android.custom.dictionary.model.ObjectBox
import com.hadi.android.custom.dictionary.model.entity.Category
import io.objectbox.Box

class CategoryDao(private val box: Box<Category>) : BaseCategoryDao {

    override fun insert(category: Category): Long {
        return box.put(category)
    }

    override fun update(category: Category): Long {
        return box.put(category)
    }

    override fun deleteWithAllWords(categoryId: Long): Boolean {
        return box.remove(categoryId)
    }

    override fun getAllCategories(): List<Category> {
        return box.all
    }

    override fun getCategory(categoryId: Long): Category? {
        return box.get(categoryId)
    }

}