package com.example.test_abschlusspruefung.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.test_abschlusspruefung.data.model.meals.Meal
import com.example.test_abschlusspruefung.data.model.categories.Category
import com.example.test_abschlusspruefung.data.model.details.MealDetails

@Database(entities = [Meal::class, MealDetails::class, Category::class], version = 1)
abstract class MealDatabase : RoomDatabase() {
    abstract val dao: MealDao
}

private lateinit var INSTANCE : MealDatabase

fun getInstance(context: Context) : MealDatabase{

    synchronized(MealDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context = context,
                klass = MealDatabase::class.java,
                name = "meal_database"
            ).build()
        }
        return INSTANCE
    }
}