package com.hadi.android.core.usecase

import com.hadi.android.core.data.CategoryRepository

class DeleteCategoryUseCase(
    private val categoryRepository: CategoryRepository,
    private val id: Long
) {
    suspend fun execute(): Boolean = categoryRepository.remove(id)
}