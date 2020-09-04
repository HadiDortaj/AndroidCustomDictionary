package com.hadi.android.custom.dictionary.presenter.fragment.wordlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.presenter.fragment.base.BaseFragment

class WordListFragment : BaseFragment() {

    private val wordListViewModel: WordListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val content = inflater.inflate(R.layout.fragment_word_list, container, false)
        return content
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getToolbarTitle(): String {
        return wordListViewModel.category.title
    }

    override fun getToolbarIcon(): Int {
        return R.drawable.ic_category
    }

}