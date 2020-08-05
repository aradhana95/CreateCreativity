package com.example.createcreativity.MainLayout.adapter

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.createcreativity.MainLayout.adapter.common.CustomViewHolder
import com.example.createcreativity.MainLayout.adapter.common.ItemClickListener
import com.example.createcreativity.MainLayout.entity.Layouts
import com.example.createcreativity.databinding.ItemLayoutsBinding

class LayoutsAdapter(val listener: ItemClickListener<Layouts>) : ListAdapter<Layouts, CustomViewHolder>(Companion) {
    companion object : DiffUtil.ItemCallback<Layouts>() {
        override fun areItemsTheSame(oldItem: Layouts, newItem: Layouts): Boolean {
            return  oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Layouts, newItem: Layouts): Boolean {
            return  oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutsBinding.inflate(inflater, parent, false)

        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentlayout = getItem(position)
        val itemBinding = holder.binding as ItemLayoutsBinding

        itemBinding.root.setOnClickListener { listener.onClickListener(currentlayout) }
        itemBinding.layouts = currentlayout
        itemBinding.executePendingBindings()
    }
}