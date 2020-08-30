package com.hadi.android.custom.dictionary.presenter.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.databinding.DialogAddCategoryBinding
import com.hadi.android.custom.dictionary.presenter.categorylist.CategoryListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddCategoryDialog() : DialogFragment() {

    val viewModel: AddCategoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: DialogAddCategoryBinding =
            DataBindingUtil.inflate(inflater, R.layout.dialog_add_category, container, false)
        binding.lifecycleOwner = this
        binding.dialog = this
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onCategoryInserted.observe(this, { category ->
            val navController = findNavController()
            navController.previousBackStackEntry?.savedStateHandle?.set(
                CategoryListFragment.OBSERVABLE_INSERTED_CATEGORY,
                category
            )
            navController.popBackStack()
        })
    }

    override fun onResume() {
        super.onResume()
        dialog?.apply {
            window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

}