package com.hadi.android.custom.dictionary.ui.addcategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.databinding.DialogAddCategoryBinding
import com.hadi.android.custom.dictionary.database.model.CategoryEntity
import com.hadi.android.custom.dictionary.ui.categorylist.CategoryListFragment
import com.hadi.android.custom.dictionary.ui.useful.Event
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddCategoryDialog() : DialogFragment() {

    private val viewModel: AddCategoryViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        dialog?.apply {
            window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            window?.setBackgroundDrawable(null)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: DialogAddCategoryBinding =
            DataBindingUtil.inflate(inflater, R.layout.dialog_add_category, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.dialog = this
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onCategoryInserted.observe(this, { category ->
            findNavController().previousBackStackEntry
                ?.savedStateHandle
                ?.getLiveData<Event<CategoryEntity>>(CategoryListFragment.KEY_LIVE_DATA_INSERTED_CATEGORY)
                ?.value = Event(category)
            findNavController().popBackStack()
        })
    }

}