package com.example.test_abschlusspruefung.ui.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test_abschlusspruefung.data.Repository
import com.example.test_abschlusspruefung.data.local.getInstance
import com.example.test_abschlusspruefung.data.model.meals.Meal
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(getInstance(application))


    fun loadMeals(category: String) : LiveData <List<Meal>> {
        viewModelScope.launch {
            repository.loadMeals(category)
        }
        return repository.meals(category)
    }
}