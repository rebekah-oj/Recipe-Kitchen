package recipekitchen.tap.recipeKitchen.utils

import android.content.Context
import android.content.SharedPreferences
import android.widget.RadioGroup

class SharedPreference(context: Context) {

    companion object {
        private const val PREFERENCE_NAME = "SharedPreferences"
        private const val PREFERENCE_USERNAME = "Username"
        private const val PREFERENCE_GENDER = "Gender"
        private const val PREFERENCE_PASSWORD = "Password"
        private const val PREFERENCE_EMAIL = "Email"
    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun getUsername(): String? {
        return preferences.getString(PREFERENCE_USERNAME, "")
    }

    fun setUsername(name: String) {
        val editor = preferences.edit()
        editor.putString(PREFERENCE_USERNAME, name)
        editor.apply()
    }

    fun getGender(): String? {
        return preferences.getString(PREFERENCE_GENDER, "")
    }

    fun setGender(gender: RadioGroup) {
        val editor = preferences.edit()
        editor.putString(PREFERENCE_GENDER, gender.toString())
        editor.apply()
    }

    fun getPassword(): String? {
        return preferences.getString(PREFERENCE_PASSWORD, "")
    }

    fun setPassword(password: String) {
        val editor = preferences.edit()
        editor.putString(PREFERENCE_PASSWORD, password)
        editor.apply()
    }

    fun getEmail(): String? {
        return preferences.getString(PREFERENCE_EMAIL, "")
    }

    fun setEmail(email: String) {
        val editor = preferences.edit()
        editor.putString(PREFERENCE_EMAIL, email)
        editor.apply()
    }
}