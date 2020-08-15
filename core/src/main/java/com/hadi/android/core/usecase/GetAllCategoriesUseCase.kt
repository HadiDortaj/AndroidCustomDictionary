package com.hadi.android.core.usecase

import com.hadi.android.core.data.CategoryRepository
import com.hadi.android.core.doman.Category

class GetAllCategoriesUseCase(
    private val categoryRepository: CategoryRepository
) {
    suspend fun execute(): List<Category> = categoryRepository.getAll()
}