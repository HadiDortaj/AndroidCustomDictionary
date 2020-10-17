package com.hadi.android.custom.dictionary.ui.worddetails

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.hadi.android.core.doman.Word

class WordDetailsViewModel @ViewModelInject constructor(
    @Assisted savedStateHandle: SavedStateHandle
) : ViewModel() {

    companion object {
        const val KEY_WORD =
            "word"  // this value should be exactly equal to the value of argument name set in the navigation graph.
    }

    val word: Word = savedStateHandle[KEY_WORD]!!

}