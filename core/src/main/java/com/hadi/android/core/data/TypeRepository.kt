package com.hadi.android.core.data

import com.hadi.android.core.doman.Type

class TypeRepository(private val dataSource: TypeDataSource) {
    suspend fun insert(type: Type): Long {
        return dataSource.insert(type)
    }

    suspend fun update(type: Type): Boolean {
        return dataSource.update(type)
    }

    suspend fun remove(type: Type): Boolean {
        return dataSource.remove(type)
    }

    suspend fun remove(id: Long): Boolean {
        return dataSource.remove(id)
    }

    suspend fun get(id: Long): Type? {
        return dataSource.get(id)
    }

    suspend fun getAll(): List<Type> {
        return dataSource.getAll()
    }
}