package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.repository

import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.models.QuoteList


sealed class Response<T>(val data : T? = null , val errorMessage: String? = null){
    class Loading<T> : Response<T>()
    class Success<T>(data: T?=null): Response<T>(data = data)
    class Error<T>(errorMessage : String) : Response<T>(errorMessage = errorMessage)
}
