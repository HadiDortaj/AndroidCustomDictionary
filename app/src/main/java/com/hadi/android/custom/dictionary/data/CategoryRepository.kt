package com.hadi.android.custom.dictionary.data

import com.hadi.android.custom.dictionary.doman.Category

class CategoryRepository(private val dataSource: CategoryDataSource) {

    fun insert(category: Category): Long {
        return dataSource.insert(category)
    }

    fun update(category: Category) : Boolean{
        return dataSource.update(category)
    }

    fun remove(category: Category): Boolean {
        return dataSource.remove(category)
    }

    fun remove(id: Long): Boolean {
        return dataSource.remove(id)
    }

    fun get(id: Long): Category? {
        return dataSource.get(id)
    }

    fun getAll(): List<Category> {
        return dataSource.getAll()
    }
}