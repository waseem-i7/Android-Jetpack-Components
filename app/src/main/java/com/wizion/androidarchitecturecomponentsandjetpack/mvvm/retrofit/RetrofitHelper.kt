package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Base64

object RetrofitHelper {

    val BASE_URL = "https://quotable.io/"

    fun getInstance() : Retrofit {
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}