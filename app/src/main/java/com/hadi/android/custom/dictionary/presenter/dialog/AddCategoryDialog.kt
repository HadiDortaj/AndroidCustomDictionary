package com.hadi.android.custom.dictionary.presenter.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.databinding.DialogAddCategoryBinding

class AddCategoryDialog() : DialogFragment() {

    private lateinit var viewModel: AddCategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddCategoryViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        //to make width full-screen
        dialog?.apply {
            window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: DialogAddCategoryBinding =
            DataBindingUtil.inflate(inflater, R.layout.dialog_add_category, container, false)
        binding.dialog = this
        binding.viewmodel = viewModel
        return binding.root
    }

}