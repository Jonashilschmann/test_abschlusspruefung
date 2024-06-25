package com.example.test_abschlusspruefung.data.model.meals

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Meal (

    @Json(name = "strMeal")
    val mealTitle: String,

    @Json(name = "strMealThumb")
    val mealThumb: String,

    @PrimaryKey
    @Json(name = "idMeal")
    val id: Int,


    var category: String = ""

)