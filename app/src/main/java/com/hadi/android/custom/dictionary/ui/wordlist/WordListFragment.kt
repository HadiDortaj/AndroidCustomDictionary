package com.hadi.android.custom.dictionary.ui.wordlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hadi.android.core.doman.Word
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.ui.base.BaseFragment
import com.hadi.android.custom.dictionary.ui.useful.Event
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_word_list.*

@AndroidEntryPoint
class WordListFragment : BaseFragment() {

    companion object {
        const val KEY_NEW_WORD_LIVE_DATA = "KEY_NEW_WORD_LIVE_DATA"
    }

    private val viewModel: WordListViewModel by viewModels()
    private lateinit var wordListAdapter: WordListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wordListAdapter = WordListAdapter(mutableListOf()) { word ->
            goToWordDetailsFragment(word)
        }
    }

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

    override fun getToolbarTitle(): String {
        return viewModel.category.title
    }

    override fun getToolbarIcon(): Int {
        return R.drawable.ic_category
    }

    private fun setupWordListRecyclerView() {
        rcvWordList.itemAnimator = null
        rcvWordList.adapter = wordListAdapter
    }

    private fun setupListeners() {
        fabAddWord.setOnClickListener {
            goToAddWordFragment()
        }
    }

    private fun setupObservers() {
        viewModel.wordListIsEmpty.observe(viewLifecycleOwner) { wordListIsEmpty ->
            txtEmptyWordListMessage.visibility = if (wordListIsEmpty) View.VISIBLE else View.GONE
        }
        viewModel.wordList.observe(viewLifecycleOwner) { newList ->
            wordListAdapter.setData(newList.toList())
        }
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Event<Word>>(
            KEY_NEW_WORD_LIVE_DATA
        )?.observe(viewLifecycleOwner) { newWord ->
            newWord.getContentIfNotHandled()?.let { viewModel.onNewWordInserted(it) }
        }
    }

    private fun goToAddWordFragment() {
        val action =
            WordListFragmentDirections.actionWordListFragmentToAddWordFragment(viewModel.category)
        findNavController().navigate(action)
    }

    private fun goToWordDetailsFragment(word: Word) {
        val action = WordListFragmentDirections.actionWordListFragmentToWordDetailsFragment(word)
        findNavController().navigate(action)
    }

}