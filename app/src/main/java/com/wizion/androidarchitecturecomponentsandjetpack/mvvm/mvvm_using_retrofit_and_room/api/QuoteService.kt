package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.api


import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("quotes")
    suspend fun getQuotes(@Query("page") page : Int) : Response<QuoteList>
}