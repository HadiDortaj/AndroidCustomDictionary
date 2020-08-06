package com.hadi.android.custom.dictionary.data

import com.hadi.android.custom.dictionary.doman.Example

interface ExampleDataSource {
    fun insert(example: Example) : Long
    fun update(example: Example) : Boolean
    fun remove(example: Example) : Boolean
    fun remove(id: Long) : Boolean
    fun get(id : Long) : Example?
    fun getAll() : List<Example>
}