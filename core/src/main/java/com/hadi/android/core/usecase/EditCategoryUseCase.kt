package com.hadi.android.core.usecase

import com.hadi.android.core.data.CategoryRepository
import com.hadi.android.core.doman.Category

class EditCategoryUseCase(
    private val categoryRepository: CategoryRepository,
    private val category: Category
) {
    suspend fun execute(): Boolean = categoryRepository.update(category)
}