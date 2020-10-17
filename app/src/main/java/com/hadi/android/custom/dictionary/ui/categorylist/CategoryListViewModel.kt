package com.hadi.android.custom.dictionary.ui.categorylist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadi.android.core.data.CategoryRepository
import com.hadi.android.core.doman.Category
import com.hadi.android.custom.dictionary.ui.useful.notifyObservers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryListViewModel @ViewModelInject constructor(val categoryRepository: CategoryRepository) :
    ViewModel() {

    val categoryList = MutableLiveData<MutableList<Category>>()
    val categoryListIsEmpty = MutableLiveData<Boolean>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val tempCategoryList = categoryRepository.getAll().toMutableList()
            checkIfCategoryListIsEmpty(tempCategoryList)
            categoryList.postValue(tempCategoryList)
        }
    }

    fun onNewCategoryInserted(category: Category) {
        categoryList.value?.let { list ->
            list.add(category)
            categoryList.notifyObservers()
            checkIfCategoryListIsEmpty(categoryList.value)
        }
    }

    private fun checkIfCategoryListIsEmpty(categoryList: List<Category>?) {
        val categoryListIsEmptyResult = categoryList?.isEmpty() ?: true
        if (categoryListIsEmpty.value == null || categoryListIsEmpty.value != categoryListIsEmptyResult) {
            categoryListIsEmpty.postValue(categoryListIsEmptyResult)
        }
    }

}