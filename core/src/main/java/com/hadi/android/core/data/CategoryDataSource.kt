package com.hadi.android.core.data

import com.hadi.android.core.doman.Category


interface CategoryDataSource {
    fun insert(category: Category) : Long
    fun update(category: Category) : Boolean
    fun remove(category: Category) : Boolean
    fun remove(id: Long) : Boolean
    fun get(id : Long) : Category?
    fun getAll() : List<Category>
}