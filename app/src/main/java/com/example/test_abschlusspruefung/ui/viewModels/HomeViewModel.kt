package com.example.test_abschlusspruefung.ui.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test_abschlusspruefung.data.Repository
import com.example.test_abschlusspruefung.data.local.getInstance
import com.example.test_abschlusspruefung.data.model.categories.Category
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    // Instanz vom Repository wird erstellt
    // Repository erhält Zugriff auf die Datenbank
    private val repository = Repository(getInstance(application))

    // Zugriff auf Repository categories
    val categories = repository.categories



    // Schritt 2
    fun loadCategoryData() {
        viewModelScope.launch {
            repository.loadCategoryData()
        }
    }
}