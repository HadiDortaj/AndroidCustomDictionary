package com.hadi.android.custom.dictionary.usecase

import com.hadi.android.custom.dictionary.data.CategoryRepository
import com.hadi.android.custom.dictionary.doman.Category

class GetAllCategoriesUseCase(
    private val categoryRepository: CategoryRepository
) {
    fun execute(): List<Category> = categoryRepository.getAll()
}