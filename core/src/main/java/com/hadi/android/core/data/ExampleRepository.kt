package com.hadi.android.core.data

import com.hadi.android.core.doman.Example

class ExampleRepository(private val dataSource: ExampleDataSource) {

    suspend fun insert(example: Example): Long {
        return dataSource.insert(example)
    }

    suspend fun update(example: Example): Boolean {
        return dataSource.update(example)
    }

    suspend fun remove(example: Example): Boolean {
        return dataSource.remove(example)
    }

    suspend fun remove(id: Long): Boolean {
        return dataSource.remove(id)
    }

    suspend fun get(id: Long): Example? {
        return dataSource.get(id)
    }

    suspend fun getAll(): List<Example> {
        return dataSource.getAll()
    }
}