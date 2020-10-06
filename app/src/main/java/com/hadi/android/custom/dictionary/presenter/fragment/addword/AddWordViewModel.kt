package com.hadi.android.custom.dictionary.presenter.fragment.addword

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.hadi.android.core.data.WordRepository
import com.hadi.android.custom.dictionary.App
import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity
import com.hadi.android.custom.dictionary.frameowork.model.DefinitionEntity
import com.hadi.android.custom.dictionary.frameowork.model.WordEntity
import com.hadi.android.custom.dictionary.frameowork.transformer.toCoreModel
import com.hadi.android.custom.dictionary.presenter.fragment.wordlist.WordListViewModel
import com.hadi.android.custom.dictionary.presenter.utils.Event
import com.hadi.android.custom.dictionary.presenter.utils.notifyObservers
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddWordViewModel @ViewModelInject constructor(
    @ApplicationContext context: Context,
    @Assisted savedStateHandle: SavedStateHandle,
    private val wordRepository: WordRepository
) : AndroidViewModel(context as App) {

    val category: CategoryEntity = savedStateHandle[WordListViewModel.KEY_CATEGORY]!!
    var wordTitle: String = ""
    val definitionList: MutableLiveData<MutableList<DefinitionEntity>> =
        MutableLiveData(mutableListOf(DefinitionEntity()))
    val insertedWord = MutableLiveData<Event<WordEntity>>()

    fun onAddDefinitionClick() {
        definitionList.value?.add(DefinitionEntity())
        definitionList.notifyObservers()
    }

    fun onSaveClick() {
        viewModelScope.launch(Dispatchers.IO) {
            val word = WordEntity(title = wordTitle).apply {
                definitionEntities.addAll(definitionList.value!!.toList())
                categoryEntity.target = category
            }
            val id = wordRepository.insert(word.toCoreModel())
            if (id != 0L) insertedWord.postValue(Event(word.apply { this.id  = id}))
        }
    }

}