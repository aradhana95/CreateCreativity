package com.example.createcreativity.MainLayout.adapter.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.createcreativity.MainLayout.adapter.LayoutsAdapter
import com.example.createcreativity.MainLayout.entity.Layouts

@BindingAdapter(value = ["setLayouts", "setlayoutsListener"])
fun RecyclerView.setRowLayouts(layouts: List<Layouts>?, listener: ItemClickListener<Layouts>?) {
    if (layouts != null && listener != null) {
        val layoutsAdapter = LayoutsAdapter(listener)
        layoutsAdapter.submitList(layouts)

        adapter = layoutsAdapter
    }
}