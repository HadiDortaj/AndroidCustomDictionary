package com.hadi.android.custom.dictionary.presenter.dialog

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hadi.android.core.data.CategoryRepository
import com.hadi.android.custom.dictionary.App
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity
import com.hadi.android.custom.dictionary.frameowork.transformer.toCoreModel
import kotlinx.coroutines.*
import java.util.*

class AddCategoryViewModel @ViewModelInject constructor(
    application: Application,
    val categoryRepository: CategoryRepository
) : AndroidViewModel(application) {

    val groupTitle: MutableLiveData<String> = MutableLiveData("")
    val groupTitleError: MutableLiveData<String?> = MutableLiveData(null)
    val onCategoryInserted: MutableLiveData<CategoryEntity> = MutableLiveData()

    fun onBtnAddCategoryClick() {
        groupTitle.value?.let { title ->
            if (title.isEmpty()) {
                groupTitleError.value = getString(R.string.error_category_title_can_not_be_empty)
                return
            }
            viewModelScope.launch(Dispatchers.IO) {
                if (categoryRepository.contains(title)) {
                    withContext(Dispatchers.Main) {
                        groupTitleError.value =
                            getString(R.string.error_duplicate_category_title)
                    }
                } else {
                    val category = CategoryEntity(title = groupTitle.value.toString())
                    val id =
                        categoryRepository.insert(category.toCoreModel())
                    withContext(Dispatchers.Main) {
                        if (id > 0) {
                            onCategoryInserted.value = category
                        } else {
                            groupTitleError.value = getString(R.string.error_unknown)
                        }
                    }
                }
            }
        }
    }

    private fun getString(id: Int): String {
        return (getApplication() as App).getString(id)
    }

}