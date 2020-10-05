package recipekitchen.tap.recipeKitchen.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import recipekitchen.tap.recipeKitchen.R


class UserProfileFragment : Fragment() {
    fun userProfileFragment() {}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this recipekitchen.tap.recipeKitchen.fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false)

        val username = view?.findViewById<TextView>(R.id.userName)
        val gender = view?.findViewById<TextView>(R.id.radioGroup)
        val bundle = arguments
        val message = bundle!!.getString("message")
        if (username != null) {
            username.text = message
        }
        if (gender != null) {
            gender.text = message
        }
        return view
    }


}