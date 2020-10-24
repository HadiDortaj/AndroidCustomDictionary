package com.hadi.android.custom.dictionary.ui.addword

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
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

    private val _isTitleEmpty = MutableLiveData<Event<Boolean>>()
    val isTitleEmpty: LiveData<Event<Boolean>>
        get() = _isTitleEmpty

    private val _isThereEmptyDefinitionWithNonEmptyExamples = MutableLiveData<Event<Boolean>>()
    val isThereEmptyDefinitionWithNonEmptyExamples: LiveData<Event<Boolean>>
        get() = _isThereEmptyDefinitionWithNonEmptyExamples

    private val _areAllDefinitionsEmpty = MutableLiveData<Event<Boolean>>()
    val areAllDefinitionsEmpty: LiveData<Event<Boolean>>
        get() = _areAllDefinitionsEmpty

    fun addDefinition() {
        definitionList.value?.add(produceEmptyDefinition())
        definitionList.notifyObservers()
    }

    fun saveWord() {
        if (validateInputs()) {
            viewModelScope.launch(Dispatchers.IO) {
                val word = Word(
                    0,
                    wordTitle,
                    category,
                    removeEmptyDefinitionAndExamples(definitionList.value)
                )
                val id = wordRepository.insert(word)
                if (id != 0L) wordInserted.postValue(Event(word))
            }
        }
    }

    private fun validateInputs(): Boolean {
        if (wordTitle.trim().isEmpty()) {
            _isTitleEmpty.value = Event(true)
            return false
        }
        var nonEmptyDefinitionTextsCount = 0
        definitionList.value?.forEach { definition ->
            if (definition.definitionText.isEmpty()) {
                definition.examples.forEach { example ->
                    if (example.originalExample.isNotEmpty() || example.extraInformation.isNotEmpty()) {
                        _isThereEmptyDefinitionWithNonEmptyExamples.value = Event(false)
                        return false;
                    }
                }
            } else {
                nonEmptyDefinitionTextsCount++
            }
        }
        if (nonEmptyDefinitionTextsCount == 0) {
            _areAllDefinitionsEmpty.value = Event(true)
            return false
        }
        return true
    }

    private fun removeEmptyDefinitionAndExamples(list: MutableList<Definition>?): MutableList<Definition> {
        val resultList = mutableListOf<Definition>()
        list?.forEach { oldDefinition ->
            val newDefinition = oldDefinition.copy().apply { examples.clear() }
            oldDefinition.examples.forEach { example ->
                if (example.originalExample.isNotEmpty() || example.extraInformation.isNotEmpty()) {
                    newDefinition.examples.add(example)
                }
            }
            //Add definition if either it has at least one example or its definition text is not empty.
            if (newDefinition.examples.size > 0 || newDefinition.definitionText.isNotEmpty()) {
                resultList.add(newDefinition)
            }
        }
        return resultList
    }

    private fun produceEmptyDefinition(): Definition {
        return Definition(0, "", "", mutableListOf())
    }

}