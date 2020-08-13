package com.hadi.android.core.data

import com.hadi.android.core.doman.Definition

class DefinitionRepository(private val dataSource: DefinitionDataSource) {

    fun insert(definition: Definition): Long {
        return dataSource.insert(definition)
    }

    fun update(definition: Definition): Boolean {
        return dataSource.update(definition)
    }

    fun remove(definition: Definition): Boolean {
        return dataSource.remove(definition)
    }

    fun remove(id: Long): Boolean {
        return dataSource.remove(id)
    }

    fun get(id: Long): Definition? {
        return dataSource.get(id)
    }

    fun getAll(): List<Definition> {
        return dataSource.getAll()
    }
}