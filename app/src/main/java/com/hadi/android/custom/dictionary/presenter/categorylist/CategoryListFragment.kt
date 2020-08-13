package com.hadi.android.custom.dictionary.presenter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hadi.android.custom.dictionary.R
import kotlinx.android.synthetic.main.fragment_category_list.*

class CategoryListFragment(private val onBtnAddCategoryClick: () -> Unit) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val content = inflater.inflate(R.layout.fragment_category_list, container, false)
        return content
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab_add_category.setOnClickListener {
            onBtnAddCategoryClick()
        }
    }

}