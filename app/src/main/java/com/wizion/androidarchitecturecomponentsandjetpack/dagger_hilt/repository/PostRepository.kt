package com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.di.ApiInterface
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.models.category.CategoryModel
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.models.post.PostModel
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.utils.NetworkResults
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiInterface: ApiInterface){

    private val _postLiveData = MutableLiveData<NetworkResults<PostModel>>()
    val postLiveData: LiveData<NetworkResults<PostModel>>
        get() = _postLiveData

    suspend fun getPost(){
        _postLiveData.postValue(NetworkResults.LOADING())
        val res = apiInterface.getPost()

        if (res.isSuccessful && res.body() != null){
            _postLiveData.postValue(NetworkResults.SUCCESS(res.body()))

        }else if (res.errorBody() != null){
            _postLiveData.postValue(NetworkResults.ERROR(message = "Something went Wrong."))
        }else{
            _postLiveData.postValue(NetworkResults.ERROR(message = "Something went Wrong."))
        }
    }



    private val _categoryLiveData = MutableLiveData<NetworkResults<CategoryModel>>()
    val categoryLiveData: LiveData<NetworkResults<CategoryModel>>
        get() = _categoryLiveData

    suspend fun getCategory(){
        _categoryLiveData.postValue(NetworkResults.LOADING())
        val res = apiInterface.getCategory()

        if (res.isSuccessful && res.body() != null){
            _categoryLiveData.postValue(NetworkResults.SUCCESS(res.body()))

        }else if (res.errorBody() != null){
            _categoryLiveData.postValue(NetworkResults.ERROR(message = "Something went Wrong."))
        }else{
            _categoryLiveData.postValue(NetworkResults.ERROR(message = "Something went Wrong."))
        }
    }




    private val _postByCategoryLiveData = MutableLiveData<NetworkResults<PostModel>>()
    val postByCategoryLiveData: LiveData<NetworkResults<PostModel>>
        get() = _postByCategoryLiveData

    suspend fun getPostByCategory(categoryId : String){
        _postByCategoryLiveData.postValue(NetworkResults.LOADING())
        val res = apiInterface.getPostByCategory(categoryId)

        if (res.isSuccessful && res.body() != null){
            _postByCategoryLiveData.postValue(NetworkResults.SUCCESS(res.body()))

        }else if (res.errorBody() != null){
            _postByCategoryLiveData.postValue(NetworkResults.ERROR(message = "Something went Wrong."))
        }else{
            _postByCategoryLiveData.postValue(NetworkResults.ERROR(message = "Something went Wrong."))
        }
    }




}