package com.example.practice_01.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.practice_01.adapter.RestaurantAdapter
import com.example.practice_01.RestaurantDto
import com.example.practice_01.service.RestaurantService
import com.example.practice_01.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RestaurantAdapter(clickListener = {
            val intent = Intent(this, DetailActivity::class.java)
            // parcelized 사용해서 직렬화 해줌
            intent.putExtra("restaurantItem", it)
            startActivity(intent)
        })
        binding.recyclerView.adapter = adapter
        getRestaurantListFromAPI()
    }

    private fun getRestaurantListFromAPI() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.mat-deal.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(RestaurantService::class.java).also {
            it.getRestaurant()
                .enqueue(object : Callback<RestaurantDto> {
                    override fun onResponse(call: Call<RestaurantDto>, response: Response<RestaurantDto>) {
                        if (response.isSuccessful.not()) {
                            Log.d("TAG", "response fail!!")
                            return
                        }
                        response.body()?.let {
                            Log.d("TAG", it.data.toString())
                            val result = response.body()?.data?.get(0)?.list
                            adapter.submitList(result)
                        }
                    }

                    override fun onFailure(call: Call<RestaurantDto>, t: Throwable) {
                        // 실패 처리에 대한 구현
                    }

                })
        }
    }
}
