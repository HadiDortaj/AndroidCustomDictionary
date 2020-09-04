package com.hadi.android.custom.dictionary.presenter.fragment.wordlist

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity

class WordListViewModel @ViewModelInject constructor(@Assisted savedStateHandle: SavedStateHandle) :
    ViewModel() {

    companion object {
        const val KEY_CATEGORY = "category" // this value should be equal to the value of argument name set to navigation graph
    }

    val category: CategoryEntity = savedStateHandle[KEY_CATEGORY]!!

}