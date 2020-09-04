package com.hadi.android.custom.dictionary.presenter.fragment.categorylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.databinding.ItemCategoryBinding
import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity

class CategoryListAdapter(
    var categoryList: List<CategoryEntity>,
    val onCategoryClicked: (Long) -> Unit
) :
    RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding: ItemCategoryBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_category,
                parent,
                false
            )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categoryEntity = categoryList[position]
        holder.bind(categoryEntity)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    inner class CategoryViewHolder(val itemCategoryBinding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(itemCategoryBinding.root) {

        init {
            itemCategoryBinding.itemRoot.setOnClickListener {
                onCategoryClicked(categoryList[adapterPosition].id)
            }
        }

        fun bind(categoryEntity: CategoryEntity) {
            itemCategoryBinding.category = categoryEntity
        }

    }

}