package com.hadi.android.custom.dictionary.data

import com.hadi.android.custom.dictionary.doman.Word

class WordRepository(private val dataSource: WordDataSource) {
    fun insert(word: Word): Long {
        return dataSource.insert(word)
    }

    fun update(word: Word): Boolean {
        return dataSource.update(word)
    }

    fun remove(word: Word): Boolean {
        return dataSource.remove(word)
    }

    fun remove(id: Long): Boolean {
        return dataSource.remove(id)
    }

    fun get(id: Long): Word? {
        return dataSource.get(id)
    }

    fun getAll(): List<Word> {
        return dataSource.getAll()
    }

    fun getAllWordsRelatedToCategory(categoryId : Long) : List<Word>{
        return dataSource.getAllWordsRelatedToCategory(categoryId)
    }
}