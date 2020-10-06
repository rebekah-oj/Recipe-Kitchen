package tap.tap.RecipeKitchen.search

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import tap.tap.RecipeKitchen.api.RecipeEndPoints

object SearchServiceBuilder {

    val retrofitService: RecipeEndPoints by lazy {
        retrofit.create(RecipeEndPoints::class.java)
    }

    private const val BASE_URL = "https://api.spoonacular.com/recipes/complexSearch"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

}
