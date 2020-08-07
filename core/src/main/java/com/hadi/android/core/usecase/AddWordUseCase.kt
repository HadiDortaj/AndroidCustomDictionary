package com.hadi.android.core.usecase

import com.hadi.android.core.data.WordRepository
import com.hadi.android.core.doman.Word

class AddWordUseCase(private val wordRepository: WordRepository, private val word: Word) {
    fun execute(): Long = wordRepository.insert(word)
}