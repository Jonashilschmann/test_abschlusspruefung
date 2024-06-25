package com.example.test_abschlusspruefung.data.remote



import com.example.test_abschlusspruefung.data.model.meals.MealListResponse
import com.example.test_abschlusspruefung.data.model.categories.CategoryListResponse
import com.example.test_abschlusspruefung.data.model.details.MealDetailsResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"


val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MealApiService {

    @GET("categories.php")
    suspend fun getCategories() : CategoryListResponse



    //https://www.themealdb.com/api/json/v1/1/filter.php?c=beef
    @GET("filter.php")
    suspend fun getMeals(@Query("c")category: String) : MealListResponse




    //https://www.themealdb.com/api/json/v1/1/lookup.php?i=52874
    @GET("lookup.php")
    suspend fun getMealDetails(@Query("i")id: Int) : MealDetailsResponse

}

object MealApi {
    val apiService: MealApiService by lazy { retrofit.create(MealApiService::class.java) }
}