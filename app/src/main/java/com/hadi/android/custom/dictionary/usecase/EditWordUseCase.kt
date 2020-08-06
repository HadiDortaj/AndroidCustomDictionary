package com.hadi.android.custom.dictionary.usecase

import com.hadi.android.custom.dictionary.data.WordRepository
import com.hadi.android.custom.dictionary.doman.Word

class EditWordUseCase(private val wordRepository: WordRepository, private val word: Word) {
    fun execute(): Boolean = wordRepository.update(word)
}