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

class AddCategoryViewModel @ViewModelInject constructor(
    application: Application,
    val categoryRepository: CategoryRepository
) : AndroidViewModel(application) {

    val groupTitle: MutableLiveData<String> = MutableLiveData("")
    val groupTitleError: MutableLiveData<String?> = MutableLiveData(null)
    val onCategoryInserted: MutableLiveData<Boolean> = MutableLiveData(false)

    fun onBtnAddCategoryClick() {
        groupTitle.value?.let { title ->
            if (title.isEmpty()) {
                groupTitleError.value = getString(R.string.error_category_title_can_not_be_empty)
                return
            }
            viewModelScope.launch {
                if (categoryRepository.contains(title)) {
                    withContext(Dispatchers.Main) {
                        groupTitleError.value =
                            getString(R.string.error_a_category_already_exists_with_the_same_title)
                    }
                } else {
                    val id =
                        categoryRepository.insert(CategoryEntity(title = groupTitle.value.toString()).toCoreModel())
                    withContext(Dispatchers.Main) {
                        if (id > 0) {
                            onCategoryInserted.value = true
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