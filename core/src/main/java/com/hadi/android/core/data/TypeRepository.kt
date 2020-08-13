package com.hadi.android.core.data

import com.hadi.android.core.doman.Type

class TypeRepository(private val dataSource: TypeDataSource) {
    fun insert(type: Type): Long {
        return dataSource.insert(type)
    }

    fun update(type: Type): Boolean {
        return dataSource.update(type)
    }

    fun remove(type: Type): Boolean {
        return dataSource.remove(type)
    }

    fun remove(id: Long): Boolean {
        return dataSource.remove(id)
    }

    fun get(id: Long): Type? {
        return dataSource.get(id)
    }

    fun getAll(): List<Type> {
        return dataSource.getAll()
    }
}