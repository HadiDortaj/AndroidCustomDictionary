package com.hadi.android.custom.dictionary.presenter.categorylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity
import com.hadi.android.custom.dictionary.presenter.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_category_list.*

@AndroidEntryPoint
class CategoryListFragment() : BaseFragment() {

    companion object {
        const val OBSERVABLE_INSERTED_CATEGORY = "OBSERVABLE_INSERTED_CATEGORY"
    }

    private val viewModel: CategoryListViewModel by viewModels()
    private lateinit var categoryListAdapter: CategoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryListAdapter = CategoryListAdapter(viewModel.categoryList.value!!)
    }

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

        setupCategoryList()
        setupObservers()

        fab_add_category.setOnClickListener {
            val action =
                CategoryListFragmentDirections.actionCategoryListFragmentToAddCategoryDialog2()
            findNavController().navigate(action)
        }
    }

    override fun getToolbarTitle(): String {
        return resources.getString(R.string.title_home)
    }

    override fun getToolbarIcon(): Int {
        return R.drawable.ic_home
    }

    private fun setupCategoryList() {
        rv_categories.setHasFixedSize(true)
        rv_categories.adapter = categoryListAdapter
    }

    private fun setupObservers() {
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<CategoryEntity>(
            OBSERVABLE_INSERTED_CATEGORY
        )?.observe(viewLifecycleOwner, { category -> viewModel.onCategoryInserted(category) })
        viewModel.categoryList.observe(viewLifecycleOwner, { categoryList ->
            categoryListAdapter.categoryList = categoryList
            categoryListAdapter.notifyDataSetChanged()
        })
        viewModel.insertedCategoryPosition.observe(viewLifecycleOwner, { position ->
            categoryListAdapter.notifyItemInserted(position)
        })
    }

}