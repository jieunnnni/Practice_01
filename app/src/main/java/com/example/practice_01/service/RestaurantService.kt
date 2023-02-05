package com.example.practice_01.service

import com.example.practice_01.RestaurantDto
import com.example.practice_01.dto.InfoDto
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantService {
    @GET("home/menu/PartnerList?PAGE=1&MEM_ID&MEM_LAT=37.557656873257315&MEM_LON=126.97443011510315&PTR_TYPE=0&SEARCH_TYPE=2&KEYWORD")
    fun getRestaurant(): Call<RestaurantDto>

    @GET("partner/PartnerInfo?PTR_ID=563")
    fun getRestaurantInfo(): Call<InfoDto>
}