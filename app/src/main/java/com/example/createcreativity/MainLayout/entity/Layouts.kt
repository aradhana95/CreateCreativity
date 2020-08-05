package com.example.createcreativity.MainLayout.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Layouts(
        val id: String,
        val title: String,
        val imageRes: Int
) : Parcelable


