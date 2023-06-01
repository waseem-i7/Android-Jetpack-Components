package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.QuoteApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class QuoteWorker(private val context : Context, private val params : WorkerParameters)
    : Worker(context,params){
    override fun doWork(): Result {
        Log.d("CodeWithWaseem","Worker Called")
        val repository = (context as QuoteApplication).quoteRepository
        CoroutineScope(Dispatchers.IO).launch {
            repository.getQuotesBackground()
        }

        return Result.success()
    }
}