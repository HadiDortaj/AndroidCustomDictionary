package com.hadi.android.custom.dictionary.usecase

import com.hadi.android.custom.dictionary.data.WordRepository
import com.hadi.android.custom.dictionary.doman.Word

class AddWordUseCase(private val wordRepository: WordRepository, private val word: Word) {
    fun execute(): Long = wordRepository.insert(word)
}