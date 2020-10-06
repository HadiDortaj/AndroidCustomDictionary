package com.hadi.android.custom.dictionary.ui.wordlist

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadi.android.core.data.WordRepository
import com.hadi.android.custom.dictionary.database.model.CategoryEntity
import com.hadi.android.custom.dictionary.database.model.WordEntity
import com.hadi.android.custom.dictionary.database.toAppModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordListViewModel @ViewModelInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val wordRepository: WordRepository
) :
    ViewModel() {

    companion object {
        const val KEY_CATEGORY =
            "category" // this value should be equal to the value of argument name set to navigation graph.
    }

    val category: CategoryEntity = savedStateHandle[KEY_CATEGORY]!!
    val wordListIsEmpty = MutableLiveData<Boolean>()
    val wordList =
        MutableLiveData<MutableList<WordEntity>>(mutableListOf()) // value should not be null

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val tempWordList =
                wordRepository.getAllWordsRelatedToCategory(category.id).map { it.toAppModel() }
            checkIfWordListIsEmpty(tempWordList)
            wordList.postValue(tempWordList.toMutableList())
        }
    }

    private fun checkIfWordListIsEmpty(wordList: List<WordEntity>?) {
        val wordListIsEmptyResult = wordList?.isEmpty() ?: true
        if (wordListIsEmpty.value == null || wordListIsEmpty.value != wordListIsEmptyResult) {
            wordListIsEmpty.postValue(wordListIsEmptyResult)
        }
    }

    fun onNewWordInserted(newWord: WordEntity) {
        wordList.value!!.add(newWord)
        wordList.value = wordList.value
        checkIfWordListIsEmpty(wordList.value)
    }

}