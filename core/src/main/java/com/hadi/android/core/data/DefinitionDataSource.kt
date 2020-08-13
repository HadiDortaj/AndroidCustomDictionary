package com.hadi.android.core.data

import com.hadi.android.core.doman.Definition

interface DefinitionDataSource {
    fun insert(definition: Definition): Long
    fun update(definition: Definition): Boolean
    fun remove(definition: Definition): Boolean
    fun remove(id: Long): Boolean
    fun get(id: Long): Definition?
    fun getAll() : List<Definition>
}