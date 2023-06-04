package com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.wizion.androidarchitecturecomponentsandjetpack.R
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.ActivityHiltMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HiltMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHiltMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHiltMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostController = findNavController(R.id.fragmentContainer)
        binding.bottomNavigationView.setupWithNavController(navHostController)
    }
}