package com.hadi.android.custom.dictionary.presenter.fragment.categorylist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadi.android.core.data.CategoryRepository
import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity
import com.hadi.android.custom.dictionary.frameowork.transformer.toAppModel
import com.hadi.android.custom.dictionary.presenter.utils.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategoryListViewModel @ViewModelInject constructor(val categoryRepository: CategoryRepository) :
    ViewModel() {

    val categoryList =
        MutableLiveData<MutableList<CategoryEntity>>(mutableListOf()) // value should not be null.
    val insertedCategoryPosition = MutableLiveData<Event<Int>>()
    val categoryListIsEmpty = MutableLiveData<Boolean>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val tempCategoryList = categoryRepository.getAll().map { it.toAppModel() }
                .toMutableList()
            checkIfCategoryListIsEmpty(tempCategoryList)
            categoryList.postValue(tempCategoryList)
        }
    }

    fun onCategoryInserted(category: CategoryEntity) {
        categoryList.value?.let { list ->
            list.add(category)
            insertedCategoryPosition.value = Event(list.size - 1)
            checkIfCategoryListIsEmpty(categoryList.value)
        }
    }

    private fun checkIfCategoryListIsEmpty(categoryList: List<CategoryEntity>?) {
        val categoryListIsEmptyResult = categoryList?.isEmpty() ?: true
        if (categoryListIsEmpty.value == null || categoryListIsEmpty.value != categoryListIsEmptyResult) {
            categoryListIsEmpty.postValue(categoryListIsEmptyResult)
        }
    }

}