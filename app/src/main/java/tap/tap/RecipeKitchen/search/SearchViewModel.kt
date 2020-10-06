package tap.tap.RecipeKitchen.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import tap.tap.RecipeKitchen.model.Result

class SearchViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var repository: SearchViewModel

    private val _recipe = MutableLiveData<List<Result>>()

    val recipe = repository._response

}