package com.example.test_abschlusspruefung.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.test_abschlusspruefung.data.model.meals.Meal
import com.example.test_abschlusspruefung.data.model.categories.Category
import com.example.test_abschlusspruefung.data.model.details.MealDetails


@Dao
interface MealDao {


    // Daten werden vom Repository in Datenbank übergeben und gespeichert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListCategory(category: List<Category>)

    //wird ausgegeben von der datenbank ins repository

    // durchgeben ans repository
    @Query("SELECT * FROM CATEGORY")
    fun getAllCategory() : LiveData<List<Category>>







    //meal list

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListMeal(meal: List<Meal>)

    @Query("SELECT * FROM Meal")
    fun getAll() : LiveData<List<Meal>>

    @Query("SELECT * FROM MEAL WHERE category=:category")
    fun getMeals(category: String) : LiveData <List<Meal>>








    //meal details

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMealDetail(mealDetails: MealDetails)

    @Query("SELECT * FROM MEALDETAILS WHERE id=:id")
    fun getMealDetails(id: Int) : LiveData<MealDetails>













}