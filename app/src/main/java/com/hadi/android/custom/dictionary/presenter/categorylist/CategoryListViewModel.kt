package com.hadi.android.custom.dictionary.presenter.categorylist

import androidx.databinding.ObservableArrayList
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadi.android.core.data.CategoryRepository
import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity
import com.hadi.android.custom.dictionary.frameowork.transformer.toAppModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategoryListViewModel @ViewModelInject constructor(val categoryRepository: CategoryRepository) :
    ViewModel() {

    val categoryList = MutableLiveData<MutableList<CategoryEntity>>(mutableListOf())
    val insertedCategoryPosition = MutableLiveData<Int>()
    val listEmpty = MutableLiveData(true)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val result = categoryRepository.getAll().map { it.toAppModel() }
                .toMutableList()
            withContext(Dispatchers.Main) {
                categoryList.value = result
                checkListEmpty()
            }
        }
    }

    fun onCategoryInserted(category: CategoryEntity) {
        val observableArrayList: ObservableArrayList<Int>? = null
        categoryList.value?.let { list ->
            list.add(category)
            insertedCategoryPosition.value = list.size - 1
            checkListEmpty()
        }
    }

    private fun checkListEmpty() {
        val listNullOrEmpty = categoryList.value.isNullOrEmpty()
        if (listNullOrEmpty) {
            if (!listEmpty.value!!) {
                listEmpty.postValue(true)
            }
        } else {
            if (listEmpty.value!!) {
                listEmpty.postValue(false)
            }
        }

    }

}