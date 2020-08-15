package com.hadi.android.core.usecase

import com.hadi.android.core.data.WordRepository

class DeleteWordUseCase(private val wordRepository: WordRepository, private val id: Long) {
    suspend fun execute(): Boolean = wordRepository.remove(id)
}