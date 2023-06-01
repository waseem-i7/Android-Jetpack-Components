package com.wizion.androidarchitecturecomponentsandjetpack.lifecycle_aware_components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wizion.androidarchitecturecomponentsandjetpack.R

class LifecycleAwareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecyle_aware)

        /*
        ## LifeCycle Aware Components ##
        *Most of the code is written inside Activity Lifecycle Methods - onCreate, onResume, onPause etc. Due to this, Activity has multiple responsibilities.
        *But there are scenarios where we want to take actions based on the activity lifecycle.
        *For e.g.
        ->Access the User's Location.
        ->Playing Video.
        ->Downloading Images.

        LifeCycle Aware Components(LiveData,ViewModel,LifecycleObserver)
        *LifeCycle Owner
        *LifeCycle Observer


         ### Important Note ###
         The onCreate and onResume methods of the activity are called before the corresponding methods in the observer, while the onPause, onStop, and onDestroy methods of the observer are called before the corresponding methods in the activity.

         */

        //Here I attached Observer to the Activity
        lifecycle.addObserver(Observer())
        Log.d("MAIN","Activity OnCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MAIN","Activity OnStart")

    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MAIN","Activity OnRestart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("MAIN","Activity OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MAIN","Activity OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MAIN","Activity OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MAIN","Activity OnDestroy")
    }
}