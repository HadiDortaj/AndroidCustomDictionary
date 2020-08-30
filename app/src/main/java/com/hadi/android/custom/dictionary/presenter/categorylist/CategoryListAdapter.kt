package com.hadi.android.custom.dictionary.presenter.categorylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.databinding.ItemCategoryBinding
import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity

class CategoryListAdapter(var categoryList: List<CategoryEntity>) :
    RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemCategoryBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_category, parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categoryEntity = categoryList[position]
        holder.bind(categoryEntity)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class CategoryViewHolder(val itemCategoryBinding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(itemCategoryBinding.root) {

        fun bind(categoryEntity: CategoryEntity) {
            itemCategoryBinding.category = categoryEntity
        }

    }

}