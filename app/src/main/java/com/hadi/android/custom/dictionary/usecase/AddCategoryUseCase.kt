package com.hadi.android.custom.dictionary.usecase

import com.hadi.android.custom.dictionary.data.CategoryRepository
import com.hadi.android.custom.dictionary.doman.Category

class AddCategoryUseCase(
    private val categoryRepository: CategoryRepository,
    private val category: Category
) {
    fun execute(): Long = categoryRepository.insert(category)
}