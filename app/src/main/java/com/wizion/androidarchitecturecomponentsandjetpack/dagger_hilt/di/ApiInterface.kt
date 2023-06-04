package com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.di

import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.models.category.CategoryModel
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.models.post.PostModel
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(Constants.POST)
    suspend fun getPost() : Response<PostModel>

    @GET(Constants.CATEGORY)
    suspend fun getCategory() : Response<CategoryModel>

    @GET(Constants.POST)
    suspend fun getPostByCategory(@Query("categories") category : String) : Response<PostModel>

}