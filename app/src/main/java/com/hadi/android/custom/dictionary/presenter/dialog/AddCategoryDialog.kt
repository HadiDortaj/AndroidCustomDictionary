package com.hadi.android.custom.dictionary.presenter.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.databinding.DialogAddCategoryBinding

class AddCategoryDialog() : DialogFragment() {

    private lateinit var viewModel: AddCategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddCategoryViewModel::class.java)
        viewModel.onCategoryInserted.observe(this, Observer<Boolean> { value ->
            if (value == true)
                dismiss()
        })
    }

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dialog?.apply {
            window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

}