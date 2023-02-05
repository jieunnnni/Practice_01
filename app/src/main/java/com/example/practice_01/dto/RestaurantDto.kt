package com.example.practice_01

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class RestaurantDto(
    val code: Int,
    val message: String,
    val data: List<Data>
)

data class Data(
    val TOTAL_CNT: Int,
    val list: List<Items>
)

@Parcelize
data class Items(
    val PTR_ID: Long,
    val PTR_COM_NM: String,
    val PTR_PROM_TITLE: String,
    val PTR_PRO_IMG: String,
    val RVW_STAR: Float,
    val PTR_REVIEW_CNT: Int
): Parcelable

