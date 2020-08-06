package com.hadi.android.custom.dictionary.data

import com.hadi.android.custom.dictionary.doman.Category

interface CategoryDataSource {
    fun insert(category: Category) : Long
    fun update(category: Category) : Boolean
    fun remove(category: Category) : Boolean
    fun remove(id: Long) : Boolean
    fun get(id : Long) : Category?
    fun getAll() : List<Category>
}