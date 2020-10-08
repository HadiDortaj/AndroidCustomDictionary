package com.hadi.android.core.data

import com.hadi.android.core.doman.Category


interface CategoryDataSource {
    suspend fun insert(category: Category) : Long
    suspend fun update(category: Category) : Boolean
    suspend fun remove(category: Category) : Boolean
    suspend fun remove(id: Long) : Boolean
    suspend fun contains(id: Long) : Boolean
    suspend fun containsTitle(title : String) : Boolean
    suspend fun get(id : Long) : Category?
    suspend fun getAll() : List<Category>
}