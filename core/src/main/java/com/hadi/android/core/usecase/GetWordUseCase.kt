package com.hadi.android.core.usecase

import com.hadi.android.core.data.WordRepository
import com.hadi.android.core.doman.Word

class GetWordUseCase(private val wordRepository: WordRepository, private val id: Long) {
    suspend fun execute(): Word? = wordRepository.get(id)
}