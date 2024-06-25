package com.example.test_abschlusspruefung.data.model.categories

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Category (

    @PrimaryKey
    @Json(name = "idCategory")
    val id: String,

    @Json(name = "strCategory")
    val category: String,

    @Json(name = "strCategoryThumb")
    val thumbnail: String
)

