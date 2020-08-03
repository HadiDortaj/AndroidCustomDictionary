package com.hadi.android.custom.dictionary.model.dao

import com.hadi.android.custom.dictionary.model.ObjectBox
import com.hadi.android.custom.dictionary.model.entity.Category
import io.objectbox.Box

class CategoryDao(private val box: Box<Category>) {

    fun insert(category: Category): Long {
        return box.put(category)
    }

    fun update(category: Category): Long {
        return box.put(category)
    }

    fun deleteWithAllWords(categoryId: Long): Boolean {
        return box.remove(categoryId)
    }

    fun getAllCategories(): List<Category> {
        return box.all
    }

    fun getCategory(categoryId: Long): Category? {
        return box.get(categoryId)
    }

}