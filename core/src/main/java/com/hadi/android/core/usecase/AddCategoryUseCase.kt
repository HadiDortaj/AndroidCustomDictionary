package com.hadi.android.core.usecase

import com.hadi.android.core.data.CategoryRepository
import com.hadi.android.core.doman.Category

class AddCategoryUseCase(
    private val categoryRepository: CategoryRepository,
    private val category: Category
) {
    suspend fun execute(): Long = categoryRepository.insert(category)
}