package com.hadi.android.custom.dictionary.ui.wordlist

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadi.android.core.data.WordRepository
import com.hadi.android.core.doman.Category
import com.hadi.android.core.doman.Word
import com.hadi.android.custom.dictionary.ui.useful.notifyObservers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordListViewModel @ViewModelInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val wordRepository: WordRepository
) : ViewModel() {

    companion object {
        const val KEY_CATEGORY =
            "category"  // this value should be exactly equal to the value of argument name set in the navigation graph.
    }

    val category: Category = savedStateHandle[KEY_CATEGORY]!!
    val wordListIsEmpty = MutableLiveData<Boolean>()
    val wordList = MutableLiveData<MutableList<Word>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val tempWordList = wordRepository.getAllWordsRelatedToCategory(category.id)
            checkIfWordListIsEmpty(tempWordList)
            wordList.postValue(tempWordList.toMutableList())
        }
    }

    private fun checkIfWordListIsEmpty(wordList: List<Word>?) {
        val wordListIsEmptyResult = wordList?.isEmpty() ?: true
        if (wordListIsEmpty.value == null || wordListIsEmpty.value != wordListIsEmptyResult) {
            wordListIsEmpty.postValue(wordListIsEmptyResult)
        }
    }

    fun onNewWordInserted(newWord: Word) {
        wordList.value?.let { list ->
            list.add(newWord)
            wordList.notifyObservers()
            checkIfWordListIsEmpty(list)
        }
    }

}