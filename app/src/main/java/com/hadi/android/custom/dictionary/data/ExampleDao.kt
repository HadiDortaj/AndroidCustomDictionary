package com.hadi.android.custom.dictionary.data

import com.hadi.android.custom.dictionary.doman.Example

class ExampleDao(private val dataSource: ExampleDataSource) {

    fun insert(example: Example): Long {
        return dataSource.insert(example)
    }

    fun update(example: Example): Boolean {
        return dataSource.update(example)
    }

    fun remove(example: Example): Boolean {
        return dataSource.remove(example)
    }

    fun remove(id: Long): Boolean {
        return dataSource.remove(id)
    }

    fun get(id: Long): Example? {
        return dataSource.get(id)
    }

    fun getAll(): List<Example> {
        return dataSource.getAll()
    }
}