package com.example.test_abschlusspruefung.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.test_abschlusspruefung.R
import com.example.test_abschlusspruefung.data.model.meals.Meal
import com.example.test_abschlusspruefung.databinding.MealItemBinding

class MealAdapter(
    var dataset: List<Meal>,
    val onMealClicked: (Meal) -> Unit
) : RecyclerView.Adapter<MealAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: MealItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = MealItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return dataset.size
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.mealNameTV.text = item.mealTitle

        holder.binding.mealThumbIV.load(item.mealThumb) {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_background)
            error(R.drawable.ic_launcher_background)
        }

        holder.binding.mealCV.setOnClickListener {
            onMealClicked(item)
        }
    }

}