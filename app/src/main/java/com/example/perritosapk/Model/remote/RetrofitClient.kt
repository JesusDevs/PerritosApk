package com.example.perritosapk.Model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitDog {

    companion object {
        private const val URL_BASE = "https://dog.ceo/api/"
        fun retrofitInstance(): DogApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(DogApi::class.java)

        }
    }
}