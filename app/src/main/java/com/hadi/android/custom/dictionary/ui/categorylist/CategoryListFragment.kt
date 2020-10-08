package com.hadi.android.custom.dictionary.ui.categorylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hadi.android.core.doman.Category
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.ui.base.BaseFragment
import com.hadi.android.custom.dictionary.ui.useful.Event
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_category_list.*

@AndroidEntryPoint
class CategoryListFragment() : BaseFragment() {

    companion object {
        const val KEY_INSERTED_CATEGORY_LIVE_DATA = "KEY_INSERTED_CATEGORY_LIVE_DATA"
    }

    private val viewModel: CategoryListViewModel by viewModels()
    private lateinit var categoryListAdapter: CategoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryListAdapter = CategoryListAdapter(mutableListOf()) { category ->
            goToWordListFragment(category)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCategoryListRecyclerView()
        setupObservers()

        fab_add_category.setOnClickListener {
            goToAddCategoryFragment()
        }
    }

    override fun getToolbarTitle(): String {
        return resources.getString(R.string.toolbar_title_category_list_fragment)
    }

    override fun getToolbarIcon(): Int {
        return R.drawable.ic_home
    }

    private fun setupCategoryListRecyclerView() {
        rv_category_list.setHasFixedSize(true)
        rv_category_list.adapter = categoryListAdapter
    }

    private fun setupObservers() {
        viewModel.categoryList.observe(viewLifecycleOwner, { categoryList ->
            categoryListAdapter.setData(categoryList.toMutableList())
        })
        viewModel.categoryListIsEmpty.observe(viewLifecycleOwner, { listEmpty ->
            text_empty_category_list_msg.visibility = if (listEmpty) View.VISIBLE else View.GONE
        })
        findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<Event<Category>>(KEY_INSERTED_CATEGORY_LIVE_DATA)
            ?.observe(viewLifecycleOwner, { category ->
                category.getContentIfNotHandled()?.let {
                    viewModel.onNewCategoryInserted(it)
                }
            })
    }

    private fun goToWordListFragment(category: Category) {
        val action =
            CategoryListFragmentDirections.actionCategoryListFragmentToWordListFragment(category)
        findNavController().navigate(action)
    }

    private fun goToAddCategoryFragment() {
        val action = CategoryListFragmentDirections.actionCategoryListFragmentToAddCategoryDialog2()
        findNavController().navigate(action)
    }

}