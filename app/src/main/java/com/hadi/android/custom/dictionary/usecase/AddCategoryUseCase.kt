package com.hadi.android.custom.dictionary.usecase

import com.hadi.android.custom.dictionary.data.CategoryRepository
import com.hadi.android.custom.dictionary.data.WordRepository
import com.hadi.android.custom.dictionary.doman.Category
import com.hadi.android.custom.dictionary.doman.Word

class AddCategoryUseCase(
    private val categoryRepository: CategoryRepository,
    private val category: Category
) {
    fun execute(): Long = categoryRepository.insert(category)
}