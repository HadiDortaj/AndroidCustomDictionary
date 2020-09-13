package com.hadi.android.custom.dictionary.presenter.fragment.addword

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.hadi.android.core.doman.Word
import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity
import com.hadi.android.custom.dictionary.frameowork.model.WordEntity
import com.hadi.android.custom.dictionary.presenter.fragment.wordlist.WordListViewModel

class AddWordViewModel @ViewModelInject constructor(@Assisted savedStateHandle: SavedStateHandle) :
    ViewModel() {

    val category: CategoryEntity = savedStateHandle[WordListViewModel.KEY_CATEGORY]!!
    var wordTitle : String = ""

}