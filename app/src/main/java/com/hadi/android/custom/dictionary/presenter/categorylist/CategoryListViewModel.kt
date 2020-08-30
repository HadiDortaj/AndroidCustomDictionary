package com.hadi.android.custom.dictionary.presenter.categorylist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadi.android.core.data.CategoryRepository
import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity
import com.hadi.android.custom.dictionary.frameowork.transformer.toAppModel
import kotlinx.coroutines.launch

class CategoryListViewModel @ViewModelInject constructor(val categoryRepository: CategoryRepository) :
    ViewModel() {

    val categoryList = MutableLiveData<MutableList<CategoryEntity>>(mutableListOf())
    val insertedCategoryPosition = MutableLiveData<Int>()

    init {
        viewModelScope.launch {
            val result = categoryRepository.getAll().map { it.toAppModel() }
                .toMutableList()
            categoryList.postValue(result)
        }
    }

    fun onCategoryInserted(category: CategoryEntity) {
        categoryList.value?.let { list ->
            list.add(category)
            insertedCategoryPosition.value = list.size - 1
        }

    }

}