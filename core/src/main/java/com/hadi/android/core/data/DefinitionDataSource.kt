package com.hadi.android.core.data

import com.hadi.android.core.doman.Definition

interface DefinitionDataSource {
    suspend fun insert(definition: Definition): Long
    suspend fun update(definition: Definition): Boolean
    suspend fun remove(definition: Definition): Boolean
    suspend fun remove(id: Long): Boolean
    suspend fun get(id: Long): Definition?
    suspend fun getAll() : List<Definition>
}