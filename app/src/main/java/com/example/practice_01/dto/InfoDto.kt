package com.example.practice_01.dto

import com.example.practice_01.Data

data class InfoDto(
    val code: Int,
    val message: String,
    val data: List<Data>
)

data class Data(
    val PTR_COM_NM: String,
    val PTR_OPEN_TM: String,
    val PTR_DAYOFF: String,
    val PTR_TEL: String,
    val PTR_ADDR1: String,
    val PTR_PARK_YN: String
)