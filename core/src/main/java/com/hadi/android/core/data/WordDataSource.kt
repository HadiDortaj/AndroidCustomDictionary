package com.hadi.android.core.data

import com.hadi.android.custom.dictionary.doman.Word

interface WordDataSource {
    fun insert(word: Word) : Long
    fun update(word: Word) : Boolean
    fun remove(word: Word) : Boolean
    fun remove(id: Long) : Boolean
    fun get(id : Long) : Word?
    fun getAll() : List<Word>
    fun getAllWordsRelatedToCategory(categoryId : Long) : List<Word>
}