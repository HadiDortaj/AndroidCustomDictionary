package com.hadi.android.core.data

import com.hadi.android.core.doman.Category

class CategoryRepository(private val dataSource: CategoryDataSource) {
    suspend fun insert(category: Category): Long {
        return dataSource.insert(category)
    }

    suspend fun update(category: Category): Boolean {
        return dataSource.update(category)
    }

    suspend fun remove(category: Category): Boolean {
        return dataSource.remove(category)
    }

    suspend fun remove(id: Long): Boolean {
        return dataSource.remove(id)
    }

    suspend fun contains(id: Long): Boolean {
        return dataSource.contains(id)
    }

    suspend fun contains(title: String): Boolean {
        return dataSource.containsTitle(title)
    }

    suspend fun get(id: Long): Category? {
        return dataSource.get(id)
    }

    suspend fun getAll(): List<Category> {
        return dataSource.getAll()
    }
}