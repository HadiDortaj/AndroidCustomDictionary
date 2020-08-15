package com.hadi.android.core.data

import com.hadi.android.core.doman.Example

interface ExampleDataSource {
    suspend fun insert(example: Example) : Long
    suspend fun update(example: Example) : Boolean
    suspend fun remove(example: Example) : Boolean
    suspend fun remove(id: Long) : Boolean
    suspend fun get(id : Long) : Example?
    suspend fun getAll() : List<Example>
}