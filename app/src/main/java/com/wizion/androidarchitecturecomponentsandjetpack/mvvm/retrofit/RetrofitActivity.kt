package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wizion.androidarchitecturecomponentsandjetpack.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        GlobalScope.launch {
            val result = quotesApi.getQuotes(1)

            if (result != null){
                val quoteList = result.body()
                quoteList?.results?.forEach {
                    Log.e("CodeWithWaseem",it.content)
                }
            }
        }
    }
}