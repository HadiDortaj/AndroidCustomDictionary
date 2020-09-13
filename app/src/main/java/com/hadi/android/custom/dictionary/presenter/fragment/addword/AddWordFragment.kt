package com.hadi.android.custom.dictionary.presenter.fragment.addword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.databinding.FragmentAddWordBinding
import com.hadi.android.custom.dictionary.presenter.fragment.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddWordFragment : BaseFragment() {

    private val viewmodel: AddWordViewModel by viewModels()
    private lateinit var definitionListAdapter : DefinitionListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddWordBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewmodel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getToolbarTitle(): String {
        return getString(R.string.toolbar_title_add_word_fragment)
    }

    override fun getToolbarIcon(): Int {
        return R.drawable.ic_add_word
    }

}