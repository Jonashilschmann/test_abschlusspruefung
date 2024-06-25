package com.example.test_abschlusspruefung.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.test_abschlusspruefung.R
import com.example.test_abschlusspruefung.databinding.FragmentDetailBinding
import com.example.test_abschlusspruefung.ui.viewModels.DetailViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //binding.titleTV.text = args.mealId.toString()
        // getMealDetails liefert die LiveData und sorgt dafür dass die Daten geladen und gecached werden.
        viewModel.getMealDetails(args.mealId).observe(viewLifecycleOwner) {

            if (it != null) {
                binding.titleTV.text = it.mealTitle

                binding.imageView.load(it.mealThumb) {
                    crossfade(true)
                    placeholder(R.drawable.ic_launcher_background)
                    error(R.drawable.ic_launcher_background)
                }

                binding.instructionsTV.text = it.instructions

                //ingredient
                binding.ingredient1TV.text = it.ingredient1
                binding.ingredient2TV.text = it.ingredient2
                binding.ingredient3TV.text = it.ingredient3
                binding.ingredient4TV.text = it.ingredient4
                binding.ingredient5TV.text = it.ingredient5
                binding.ingredient6TV.text = it.ingredient6
                binding.ingredient7TV.text = it.ingredient7
                binding.ingredient8TV.text = it.ingredient8
                binding.ingredient9TV.text = it.ingredient9
                binding.ingredient10TV.text = it.ingredient10
                binding.ingredient11TV.text = it.ingredient11
                binding.ingredient12TV.text = it.ingredient12
                binding.ingredient13TV.text = it.ingredient13
                binding.ingredient14TV.text = it.ingredient14
                binding.ingredient15TV.text = it.ingredient15
                binding.ingredient16TV.text = it.ingredient16
                binding.ingredient17TV.text = it.ingredient17
                binding.ingredient18TV.text = it.ingredient18
                binding.ingredient19TV.text = it.ingredient19
                binding.ingredient20TV.text = it.ingredient20

                //measure
                binding.measure1TV.text = it.measure1
                binding.measure2TV.text = it.measure2
                binding.measure3TV.text = it.measure3
                binding.measure4TV.text = it.measure4
                binding.measure5TV.text = it.measure5
                binding.measure6TV.text = it.measure6
                binding.measure7TV.text = it.measure7
                binding.measure8TV.text = it.measure8
                binding.measure9TV.text = it.measure9
                binding.measure10TV.text = it.measure10
                binding.measure11TV.text = it.measure11
                binding.measure12TV.text = it.measure12
                binding.measure13TV.text = it.measure13
                binding.measure14TV.text = it.measure14
                binding.measure15TV.text = it.measure15
                binding.measure16TV.text = it.measure16
                binding.measure17TV.text = it.measure17
                binding.measure18TV.text = it.measure18
                binding.measure19TV.text = it.measure19
                binding.measure20TV.text = it.measure20

            }


        }




    }


}