package com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.wizion.androidarchitecturecomponentsandjetpack.R
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.adapter.PostAdapter
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.interfaces.CategoryClick
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.utils.NetworkResults
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.viewmodel.PostViewModel
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.FragmentCategoryPostBinding
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryPostFragment : Fragment() {

    private lateinit var binding: FragmentCategoryPostBinding

    private val args : CategoryPostFragmentArgs by navArgs()

    private val postViewModel by viewModels<PostViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoryPostBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment

        args.category?.let { postViewModel.getPostByCategory(it) }
        postViewModel.postByCategoryLiveData.observe(requireActivity()) {
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

                else -> {}
            }
        }

        return binding.root
    }

}
