package com.hadi.android.custom.dictionary.ui.addword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.hadi.android.core.doman.Word
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.databinding.FragmentAddWordBinding
import com.hadi.android.custom.dictionary.ui.base.BaseFragment
import com.hadi.android.custom.dictionary.ui.useful.Event
import com.hadi.android.custom.dictionary.ui.utils.showSnackBar
import com.hadi.android.custom.dictionary.ui.wordlist.WordListFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_word.*

@AndroidEntryPoint
class AddWordFragment : BaseFragment() {

    private val viewModel: AddWordViewModel by viewModels()
    private lateinit var definitionListAdapter: DefinitionListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddWordBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel
        binding.fragment = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    override fun getToolbarTitle(): String {
        return getString(R.string.toolbar_title_add_word_fragment)
    }

    override fun getToolbarIcon(): Int {
        return R.drawable.ic_add_word
    }

    fun onCancelClick() {
        findNavController().popBackStack()
    }

    private fun setupRecyclerView() {
        definitionListAdapter = DefinitionListAdapter(mutableListOf())
        rcvDefinitionList.itemAnimator = null
        rcvDefinitionList.adapter = definitionListAdapter
    }

    private fun setupObservers() {
        viewModel.definitionList.observe(viewLifecycleOwner) { newList ->
            definitionListAdapter.setData(newList.toList())
        }
        viewModel.wordInserted.observe(viewLifecycleOwner) { newWord ->
            findNavController().previousBackStackEntry?.savedStateHandle?.getLiveData<Event<Word>>(
                WordListFragment.KEY_NEW_WORD_LIVE_DATA
            )?.value = newWord
            findNavController().popBackStack()
        }
        viewModel.isTitleEmpty.observe(viewLifecycleOwner) {
            showSnackBar(R.string.error_word_title_is_empty, Snackbar.LENGTH_SHORT)
        }
        viewModel.isThereEmptyDefinitionWithNonEmptyExamples.observe(viewLifecycleOwner) {
            showSnackBar(
                R.string.error_there_is_an_empty_definition_with_non_empty_example,
                Snackbar.LENGTH_SHORT
            )
        }
        viewModel.areAllDefinitionsEmpty.observe(viewLifecycleOwner) {
            showSnackBar(
                R.string.error_there_should_be_at_least_one_non_empty_definition_text,
                Snackbar.LENGTH_SHORT
            )
        }
    }

}