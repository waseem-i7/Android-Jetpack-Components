package com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.adapter.CategoryAdapter
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.interfaces.CategoryClick
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.utils.NetworkResults
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.viewmodel.PostViewModel
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.FragmentCategoryBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CategoryFragment : Fragment(), CategoryClick {

    private lateinit var binding: FragmentCategoryBinding

    private val postViewModel by viewModels<PostViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment

        postViewModel.getCategory()
        postViewModel.categoryLiveData.observe(requireActivity()) {
            Log.d("Waseem", "onCreateView: ${it.data}")
            when (it) {
                is NetworkResults.LOADING -> {
                   binding.progressBar.visibility = View.VISIBLE
                }

                is NetworkResults.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { it1 ->
                        binding.recyclerView.adapter = CategoryAdapter(it1,this)
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

    override fun onCategoryClick(category: String) {
        val direction  = CategoryFragmentDirections.actionCategoryFragmentToCategoryPostFragment(category)
        findNavController().navigate(direction)
    }


}