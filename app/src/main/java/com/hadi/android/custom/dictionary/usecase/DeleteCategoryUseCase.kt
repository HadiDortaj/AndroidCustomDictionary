package com.hadi.android.custom.dictionary.usecase

import com.hadi.android.custom.dictionary.data.CategoryRepository

class DeleteCategoryUseCase(
    private val categoryRepository: CategoryRepository,
    private val id: Long
) {
    fun execute(): Boolean = categoryRepository.remove(id)
}