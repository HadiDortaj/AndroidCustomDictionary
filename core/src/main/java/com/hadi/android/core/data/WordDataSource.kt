package com.hadi.android.core.data

import com.hadi.android.core.doman.Word

interface WordDataSource {
    suspend fun insert(word: Word) : Long
    suspend fun update(word: Word) : Boolean
    suspend fun remove(word: Word) : Boolean
    suspend fun remove(id: Long) : Boolean
    suspend fun get(id : Long) : Word?
    suspend fun getAll() : List<Word>
    suspend fun getAllWordsRelatedToCategory(categoryId : Long) : List<Word>
}