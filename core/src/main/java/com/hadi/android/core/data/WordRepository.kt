package com.hadi.android.core.data

import com.hadi.android.core.doman.Word

class WordRepository(private val dataSource: WordDataSource) {
    suspend fun insert(word: Word): Long {
        return dataSource.insert(word)
    }

    suspend fun update(word: Word): Boolean {
        return dataSource.update(word)
    }

    suspend fun remove(word: Word): Boolean {
        return dataSource.remove(word)
    }

    suspend fun remove(id: Long): Boolean {
        return dataSource.remove(id)
    }

    suspend fun get(id: Long): Word? {
        return dataSource.get(id)
    }

    suspend fun getAll(): List<Word> {
        return dataSource.getAll()
    }

    suspend fun getAllWordsRelatedToCategory(categoryId: Long): List<Word> {
        return dataSource.getAllWordsRelatedToCategory(categoryId)
    }
}