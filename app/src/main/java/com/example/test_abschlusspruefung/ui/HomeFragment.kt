package com.example.test_abschlusspruefung.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.test_abschlusspruefung.adapter.CategoryAdapter
import com.example.test_abschlusspruefung.data.model.categories.Category
import com.example.test_abschlusspruefung.databinding.FragmentHomeBinding
import com.example.test_abschlusspruefung.ui.viewModels.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Schritt 1
        // ruft im HomeViewModel die Funktion auf fun loadCategoryData()
        viewModel.loadCategoryData()

        // schaut auf die categories im HomeviewModel ob sie sich verändern
        viewModel.categories.observe(viewLifecycleOwner) {categories ->
            Log.d("CategoryLiveData", categories.toString())

            binding.categoryRV.adapter = CategoryAdapter(categories) {clickedCategory->
                Log.d("onCategoryClicked", clickedCategory.category)
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToListFragment(clickedCategory.category))
            }

        }







    }
}