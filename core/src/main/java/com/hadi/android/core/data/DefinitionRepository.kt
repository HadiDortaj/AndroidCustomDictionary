package com.hadi.android.core.data

import com.hadi.android.core.doman.Definition

class DefinitionRepository(private val dataSource: DefinitionDataSource) {

    suspend fun insert(definition: Definition): Long {
        return dataSource.insert(definition)
    }

    suspend fun update(definition: Definition): Boolean {
        return dataSource.update(definition)
    }

    suspend fun remove(definition: Definition): Boolean {
        return dataSource.remove(definition)
    }

    suspend fun remove(id: Long): Boolean {
        return dataSource.remove(id)
    }

    suspend fun get(id: Long): Definition? {
        return dataSource.get(id)
    }

    suspend fun getAll(): List<Definition> {
        return dataSource.getAll()
    }
}