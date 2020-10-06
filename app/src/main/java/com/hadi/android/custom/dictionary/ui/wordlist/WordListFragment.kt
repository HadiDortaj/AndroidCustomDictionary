package com.hadi.android.custom.dictionary.ui.wordlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.database.model.WordEntity
import com.hadi.android.custom.dictionary.ui.base.BaseFragment
import com.hadi.android.custom.dictionary.ui.useful.Event
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_word_list.*

@AndroidEntryPoint
class WordListFragment : BaseFragment() {

    companion object {
        const val KEY_NEW_WORD = "KEY_NEW_WORD"
    }

    private val viewModel: WordListViewModel by viewModels()
    private val wordListAdapter: WordListAdapter = WordListAdapter(mutableListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_word_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupObservers()
        setupWordListRecyclerView()
    }

    private fun setupWordListRecyclerView() {
        rv_word_list.adapter = wordListAdapter
    }

    override fun getToolbarTitle(): String {
        return viewModel.category.title
    }

    override fun getToolbarIcon(): Int {
        return R.drawable.ic_category
    }

    private fun setupListeners() {
        fab_add_word.setOnClickListener {
            goToAddWordFragment()
        }
    }

    private fun setupObservers() {
        viewModel.wordListIsEmpty.observe(viewLifecycleOwner) { wordListIsEmpty ->
            text_empty_word_list_msg.visibility = if (wordListIsEmpty) View.VISIBLE else View.GONE
        }
        viewModel.wordList.observe(viewLifecycleOwner) { newList ->
            wordListAdapter.setData(newList.toMutableList())
        }
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Event<WordEntity>>(
            KEY_NEW_WORD
        )?.observe(viewLifecycleOwner) { newWord ->
            newWord.getContentIfNotHandled()?.let { viewModel.onNewWordInserted(it) }
        }
    }

    private fun goToAddWordFragment() {
        val action =
            WordListFragmentDirections.actionWordListFragmentToAddWordFragment(viewModel.category)
        findNavController().navigate(action)
    }

}