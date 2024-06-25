package com.example.test_abschlusspruefung.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.test_abschlusspruefung.R
import com.example.test_abschlusspruefung.data.model.categories.Category
import com.example.test_abschlusspruefung.databinding.CategoryItemBinding


class CategoryAdapter(
    var dataset: List<Category>,
    val onCategoryClicked: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        Log.d("category", item.category)

        holder.binding.textView.text = item.category

        holder.binding.imageView2.load(item.thumbnail) {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_background)
            error(R.drawable.ic_launcher_background)
        }

        holder.binding.categoryCV.setOnClickListener {
            Log.d("onCategoryClicked", item.category)
            onCategoryClicked(item)
        }


    }


    override fun getItemCount(): Int {
        return dataset.size
    }
}