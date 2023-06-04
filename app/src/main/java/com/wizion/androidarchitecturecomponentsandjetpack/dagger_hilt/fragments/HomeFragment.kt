package com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.wizion.androidarchitecturecomponentsandjetpack.R
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.adapter.CategoryAdapter
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.adapter.PostAdapter
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.utils.NetworkResults
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.viewmodel.PostViewModel
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val postViewModel by viewModels<PostViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment

        postViewModel.getPost()
        postViewModel.postLiveData.observe(requireActivity()) {
            Log.d("Waseem", "onCreateView: ${it.data}")

            when (it) {
                is NetworkResults.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is NetworkResults.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { it1 ->
                        binding.recyclerView.adapter = PostAdapter(it1)
                    }
                }

                is NetworkResults.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        return binding.root
    }


}