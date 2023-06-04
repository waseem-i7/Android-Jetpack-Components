package com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.models.category.CategoryModel
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.models.post.PostModel
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.repository.PostRepository
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.utils.NetworkResults
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel(){

    val postLiveData: LiveData<NetworkResults<PostModel>>
        get() = postRepository.postLiveData

    val postByCategoryLiveData: LiveData<NetworkResults<PostModel>>
        get() = postRepository.postByCategoryLiveData

    val categoryLiveData: LiveData<NetworkResults<CategoryModel>>
        get() = postRepository.categoryLiveData

    fun getPost(){
        viewModelScope.launch(Dispatchers.IO) {
            postRepository.getPost()
        }
    }

    fun getCategory(){
        viewModelScope.launch(Dispatchers.IO) {
            postRepository.getCategory()
        }
    }


    fun getPostByCategory(categoryId : String){
        viewModelScope.launch(Dispatchers.IO) {
            postRepository.getPostByCategory(categoryId)
        }
    }
}