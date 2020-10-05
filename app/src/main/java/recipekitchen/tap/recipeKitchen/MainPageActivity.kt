package recipekitchen.tap.recipeKitchen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main_page.*


class MainPageActivity : AppCompatActivity() {

    private lateinit var adpater: ViewPagerAdapter
    private lateinit var viewPager: ViewPager2

    // tab titles
    private val titles = arrayOf("Search", "Home", "Profile")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        init()
    }

    private fun init() {
        // removing toolbar elevation
        supportActionBar!!.elevation = 0f
        viewPager.adapter = adpater

        // attaching tab mediator
        TabLayoutMediator(
            tabLayout, pager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = titles[position]
        }.attach()
    }

}