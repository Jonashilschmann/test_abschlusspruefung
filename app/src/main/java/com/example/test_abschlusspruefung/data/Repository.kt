package com.example.test_abschlusspruefung.data

import android.util.Log
import com.example.test_abschlusspruefung.data.local.MealDatabase
import com.example.test_abschlusspruefung.data.model.meals.Meal
import com.example.test_abschlusspruefung.data.remote.MealApi

const val TAG = "Repository"

// Repository kriegt Zugriff auf die Database
class Repository(val database: MealDatabase) {


    // livedata Category wird durchgegeben, erst HomeviewModel, dann ui
    val categories = database.dao.getAllCategory()

    // Schritt 3
    // Category Data
    suspend fun loadCategoryData() {

        val categoryResponse = MealApi.apiService.getCategories()
        Log.d("Rep", categoryResponse.toString())

        val categoryList = categoryResponse.categories

        // neue Daten Werden im Dao überschrieben
        database.dao.insertListCategory(categoryList)

    }









    val meals = database.dao.getAll()

    fun meals(category: String) = database.dao.getMeals(category)

    suspend fun loadMeals(category: String) : List<Meal> {

            val response = MealApi.apiService.getMeals(category)
            Log.d(TAG, "API Response: $response")

            response.meals.forEach {meal ->
                meal.category = category
            }

            val mealList = response.meals

            database.dao.insertListMeal(mealList)
            Log.d(TAG, "Meals inserted into database")
            return mealList

    }










    fun mealDetails(id: Int) = database.dao.getMealDetails(id)

    suspend fun cacheMealDetails(id: Int) {
        try {
            //Lade Meal Details
            val mealDetails = MealApi.apiService.getMealDetails(id).meals.first()
            //speicher in Room Datenbank
            database.dao.insertMealDetail(mealDetails)


        } catch (ex: Exception) {
            Log.e(TAG, ex.toString())
        }
    }





}