package com.example.createcreativity.MainLayout.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class LayoutsCategory(
        val id: String,
        val title: String,
        val books: List<Layouts>
) : Parcelable