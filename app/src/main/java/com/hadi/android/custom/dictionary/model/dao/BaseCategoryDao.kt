package com.hadi.android.custom.dictionary.model.dao

import com.hadi.android.custom.dictionary.model.entity.Category

interface BaseCategoryDao {
    fun insert(category: Category): Long
    fun update(category: Category): Long
    fun deleteWithAllWords(categoryId: Long): Boolean
    fun getAllCategories(): List<Category>
    fun getCategory(categoryId: Long): Category?
}