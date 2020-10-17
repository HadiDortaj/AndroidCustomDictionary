package com.hadi.android.custom.dictionary.ui.worddetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_word_detatils.*

@AndroidEntryPoint
class WordDetailsFragment : BaseFragment() {

    private val viewModel: WordDetailsViewModel by viewModels()
    private lateinit var definitionDetailListAdapter: DefinitionDetailListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        definitionDetailListAdapter = DefinitionDetailListAdapter(mutableListOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_word_detatils, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDefinitionDetailsRecyclerView()
    }

    private fun setupDefinitionDetailsRecyclerView() {
        rcvDetailDefinitionList.itemAnimator = null
        rcvDetailDefinitionList.adapter =
            definitionDetailListAdapter.apply { setData(viewModel.word.definitions) }
    }

    override fun getToolbarTitle(): String {
        return viewModel.word.title
    }

    override fun getToolbarIcon(): Int {
        return ICON_NONE
    }

}