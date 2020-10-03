package tap.tap.RecipeKitchen

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.password

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {
            signUpUser()
        }
    }

    private fun signUpUser() {
        if (email.toString().isEmpty()) {
            email.error = "Please enter email"
            email.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()) {
            email.error = "Please enter valid email"
            email.requestFocus()
            return
        }

        if (password.toString().isEmpty()) {
            password.error = "Please enter password"
            password.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(email.toString(), password.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(
                        baseContext, "Sign Up failed. Try again after some time.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}