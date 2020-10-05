package recipekitchen.tap.recipeKitchen.fragment

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import recipekitchen.tap.recipeKitchen.R

class SearchFragment : Fragment() {

    var intent = Intent()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this recipekitchen.tap.recipeKitchen.fragment
        return inflater.inflate(R.layout.fragment_search, container, false)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntent(intent)
    }

    fun onNewIntent(intent: Intent) {

        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {

        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            //use the query to options_menu your data somehow
        }
    }
}