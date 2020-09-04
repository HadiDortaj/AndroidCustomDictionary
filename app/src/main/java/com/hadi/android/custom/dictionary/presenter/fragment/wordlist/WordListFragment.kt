package com.hadi.android.custom.dictionary.presenter.fragment.wordlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.presenter.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_word_list.*

class WordListFragment : BaseFragment() {

    private val wordListViewModel: WordListViewModel by viewModels()
    private val args: WordListFragmentArgs by navArgs()

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
        text_empty_word_list_msg.text = args.categoryId.toString()
    }

    override fun getToolbarTitle(): String {
        return ""
    }

    override fun getToolbarIcon(): Int {
        return R.drawable.ic_category
    }

}