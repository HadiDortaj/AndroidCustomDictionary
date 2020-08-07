package com.hadi.android.core.usecase

import com.hadi.android.core.data.WordRepository
import com.hadi.android.core.doman.Word

class EditWordUseCase(private val wordRepository: WordRepository, private val word: Word) {
    fun execute(): Boolean = wordRepository.update(word)
}