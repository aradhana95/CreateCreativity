package com.example.createcreativity.MainLayout.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.createcreativity.MainLayout.adapter.common.CustomViewHolder
import com.example.createcreativity.MainLayout.adapter.common.ItemClickListener
import com.example.createcreativity.MainLayout.entity.LayoutsCategory
import com.example.createcreativity.MainLayout.entity.Layouts
import com.example.createcreativity.databinding.ItemLayoutsCategoryBinding

class LayoutsCategoryAdapter(private val listener: ItemClickListener<Layouts>) : androidx.recyclerview.widget.ListAdapter<LayoutsCategory, CustomViewHolder>(Companion) {
    private val viewPool = RecyclerView.RecycledViewPool()

    companion object : DiffUtil.ItemCallback<LayoutsCategory>() {
        override fun areItemsTheSame(oldItem: LayoutsCategory, newItem: LayoutsCategory): Boolean {
            return  oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: LayoutsCategory, newItem: LayoutsCategory): Boolean {
            return  oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutsCategoryBinding.inflate(inflater, parent, false)

        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentBookCategory = getItem(position)
        val itemBinding = holder.binding as ItemLayoutsCategoryBinding

        itemBinding.layoutsListener = listener
        itemBinding.layoutsCategory = currentBookCategory
        itemBinding.nestedRecyclerView.setRecycledViewPool(viewPool)
        itemBinding.executePendingBindings()
    }
}