package com.example.test_abschlusspruefung.ui.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.test_abschlusspruefung.data.Repository
import com.example.test_abschlusspruefung.data.local.getInstance
import com.example.test_abschlusspruefung.data.model.details.MealDetails
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : AndroidViewModel(application) {

    // Repository erhält Mealdatenbank
    val repository = Repository(getInstance(application))

    fun getMealDetails(id: Int) : LiveData<MealDetails> {
        viewModelScope.launch {
            repository.cacheMealDetails(id)
            Log.d("DetailViewModel","1")
        }
        Log.d("DetailViewModel","2")
        return repository.mealDetails(id)

    }






}