package com.hadi.android.custom.dictionary.ui.addword

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.hadi.android.core.data.WordRepository
import com.hadi.android.core.doman.Category
import com.hadi.android.core.doman.Definition
import com.hadi.android.core.doman.Word
import com.hadi.android.custom.dictionary.App
import com.hadi.android.custom.dictionary.ui.wordlist.WordListViewModel
import com.hadi.android.custom.dictionary.ui.useful.Event
import com.hadi.android.custom.dictionary.ui.useful.notifyObservers
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddWordViewModel @ViewModelInject constructor(
    @ApplicationContext context: Context,
    @Assisted savedStateHandle: SavedStateHandle,
    private val wordRepository: WordRepository
) : AndroidViewModel(context as App) {

    val category: Category = savedStateHandle[WordListViewModel.KEY_CATEGORY]!!
    var wordTitle: String = ""
    val definitionList: MutableLiveData<MutableList<Definition>> =
        MutableLiveData(mutableListOf(produceEmptyDefinition()))
    val wordInserted = MutableLiveData<Event<Word>>()

    fun addDefinition() {
        definitionList.value?.add(produceEmptyDefinition())
        definitionList.notifyObservers()
    }

    fun saveWord() {
        viewModelScope.launch(Dispatchers.IO) {
            val word = Word(0, wordTitle, category, definitionList.value!!)
            val id = wordRepository.insert(word)
            if (id != 0L) wordInserted.postValue(Event(word))
        }
    }

    private fun produceEmptyDefinition(): Definition {
        return Definition(0, "", "", mutableListOf())
    }

}