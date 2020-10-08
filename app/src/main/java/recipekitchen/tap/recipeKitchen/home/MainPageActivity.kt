package recipekitchen.tap.recipeKitchen.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main_page.*
import recipekitchen.tap.recipeKitchen.R
import recipekitchen.tap.recipeKitchen.fragment.SearchFragment
import recipekitchen.tap.recipeKitchen.profile.UserProfileFragment


class MainPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        title = resources.getString(R.string.home)
        loadFragment(HomeFragment())

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.searchFragment -> {
                    title = resources.getString(R.string.search)
                    loadFragment(SearchFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.homeFragment -> {
                    title = resources.getString(R.string.home)
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.userProfileFragment -> {
                    title = resources.getString(R.string.profile)
                    loadFragment(UserProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }
    }

    private fun loadFragment(fragment: Fragment) {
        // load recipekitchen.tap.recipeKitchen.fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}

