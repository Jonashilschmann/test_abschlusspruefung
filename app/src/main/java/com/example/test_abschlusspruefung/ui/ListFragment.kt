package com.example.test_abschlusspruefung.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.test_abschlusspruefung.adapter.CategoryAdapter
import com.example.test_abschlusspruefung.ui.viewModels.ListViewModel
import com.example.test_abschlusspruefung.adapter.MealAdapter
import com.example.test_abschlusspruefung.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()
    private lateinit var mealAdapter: MealAdapter
    private lateinit var category: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        category = ListFragmentArgs.fromBundle(requireArguments()).category

        mealAdapter = MealAdapter(emptyList()) { meal ->

            findNavController().navigate(
                ListFragmentDirections.actionListFragmentToDetailFragment(meal.id)
            )
        }

        binding.mealRV.adapter = mealAdapter

        viewModel.loadMeals(category).observe(viewLifecycleOwner) { meals ->
            mealAdapter.dataset = meals
            mealAdapter.notifyDataSetChanged()
        }
        viewModel.loadMeals(category)
    }
}