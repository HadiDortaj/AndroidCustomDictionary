package com.hadi.android.custom.dictionary.usecase

import com.hadi.android.custom.dictionary.data.WordRepository
import com.hadi.android.custom.dictionary.doman.Word

class GetWordUseCase(private val wordRepository: WordRepository, private val id: Long) {
    fun execute(): Word? = wordRepository.get(id)
}