package com.hadi.android.core.data

import com.hadi.android.core.doman.Example

interface ExampleDataSource {
    fun insert(example: Example) : Long
    fun update(example: Example) : Boolean
    fun remove(example: Example) : Boolean
    fun remove(id: Long) : Boolean
    fun get(id : Long) : Example?
    fun getAll() : List<Example>
}