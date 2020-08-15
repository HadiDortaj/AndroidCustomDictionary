package com.hadi.android.core.usecase

import com.hadi.android.core.data.CategoryRepository

class CheckCategoryExistsUseCase(
    private val categoryRepository: CategoryRepository,
    private val title: String
) {
    suspend fun execute(): Boolean = categoryRepository.contains(title)
}