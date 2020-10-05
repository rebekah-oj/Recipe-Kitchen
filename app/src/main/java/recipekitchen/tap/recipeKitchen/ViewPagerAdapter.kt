package recipekitchen.tap.recipeKitchen

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    // tab titles
    private val titles = arrayOf("Search", "Home", "Profile")

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return SearchFragment()
            1 -> return HomeFragment()
            2 -> return UserProfileFragment()
        }
        return SearchFragment()
    }
}