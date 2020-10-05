package recipekitchen.tap.recipeKitchen.register

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_register.*
import recipekitchen.tap.recipeKitchen.R
import recipekitchen.tap.recipeKitchen.UserProfileFragment
import recipekitchen.tap.recipeKitchen.databinding.ActivityRegisterBinding

class RegistrationActivity : AppCompatActivity() {
    private var imageView: ImageView? = null
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var registrationViewModel: RegistrationViewModel
    private var cameraRequestCode = 0
    private var galleryRequestCode = 1

    //Function to start the verification activity
    fun sendMessage(view: View) {
        val intent = Intent(this, UserProfileFragment::class.java)
        startActivity(intent)
    }

    var name = ""
    var pasword = ""
    val email = ""
    val confirmPassword = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        binding.lifecycleOwner = this
        registrationViewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)
        imageView = findViewById(R.id.imageViewLayout)

        binding.viewModel = registrationViewModel
        binding.imageViewLayout.setOnClickListener {
            selectImage(this@RegistrationActivity)
        }

        //  name = findViewById<TextInputLayout>(R.id.nameLayout).toString()
        //  address = findViewById<TextInputLayout>()
        //   mPreferences = getSharedPreferences(
        //    sharedPrefFile, MODE_PRIVATE
        //  )
    }

    //Function for radiogroup
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.radioButton ->
                    if (checked) {

                    }
                R.id.radioButton1 ->
                    if (checked) {

                    }
            }
        }
    }

    //companion object used to initialize external storage and camera permission
    companion object {

        private const val PERMISSION_READ_EXTERNAL_STORAGE =
            Manifest.permission.READ_EXTERNAL_STORAGE
        private const val PERMISSION_CAMERA = Manifest.permission.CAMERA

        private const val REQUEST_CAMERA_PERMISSION = 0
        private const val REQUEST_EXTERNAL_STORAGE_PERMISSION = 1

    }

    //Function to launch gallery
    private fun launchCamera(cameraRequestCode: Int) {
        if (isCameraPermissionGranted()) {
            startActivityForResult(
                Intent(MediaStore.ACTION_IMAGE_CAPTURE),
                cameraRequestCode
            )
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_CAMERA_PERMISSION
            )
        }
    }

    //Function to launch the gallery
    private fun launchGallery(galleryRequestCode: Int) {
        if (isExternalStoragePermissionGranted()) {
            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(intent, galleryRequestCode)
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(PERMISSION_READ_EXTERNAL_STORAGE),
                REQUEST_EXTERNAL_STORAGE_PERMISSION
            )
        }
    }

    //Function for when external storage permission is granted
    private fun isExternalStoragePermissionGranted(): Boolean =
        ContextCompat.checkSelfPermission(
            this,
            PERMISSION_READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED

    private fun isCameraPermissionGranted(): Boolean =
        ContextCompat.checkSelfPermission(
            this,
            PERMISSION_CAMERA
        ) == PackageManager.PERMISSION_GRANTED

    //function to request camera permission
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            //statement for when camera permission is granted, launch camera, if not display a toast that says "permission denied"
            REQUEST_CAMERA_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    launchCamera(cameraRequestCode)
                else
                    Toast.makeText(
                        this,
                        "Permission denied. Unable to access camera",
                        Toast.LENGTH_LONG
                    ).show()
            }

            //statement for when access to gallery is granted, launch gallery or display a message that says "permissioned denied"
            REQUEST_EXTERNAL_STORAGE_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    launchGallery(galleryRequestCode)
                else
                    Toast.makeText(
                        this,
                        "Permission denied. Unable to access pictures on your device",
                        Toast.LENGTH_LONG
                    ).show()
            }
        }
    }

    //Function to select the image
    private fun selectImage(context: Context) {
        //dialog pops up and displays a message
        val options =
            arrayOf<CharSequence>("Take Photo", "Choose from Gallery", "Cancel")
        val builder = AlertDialog.Builder(context)

        //choose a photo
        builder.setTitle("Choose your tap.tap.RecipeKitchen.profile picture")
        builder.setItems(options) { dialog, item ->

            //take a photo
            if (options[item] == "Take Photo") {
                launchCamera(REQUEST_CAMERA_PERMISSION)

                //select a photo from gallery
            } else if (options[item] == "Choose from Gallery") {
                launchGallery(REQUEST_EXTERNAL_STORAGE_PERMISSION)
            } else if (options[item] == "Cancel") {
                dialog.dismiss()
            }
        }
        builder.show()
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("RegistrationActivity", "request: $requestCode, $data")
        if (resultCode != Activity.RESULT_CANCELED) {
            when (requestCode) {
                0 -> if (resultCode == Activity.RESULT_OK && data != null) {
                    val selectedImage = data.extras!!["data"] as Bitmap?
                    imageViewLayout!!.setImageBitmap(selectedImage)
                }
                1 -> if (resultCode == Activity.RESULT_OK && data != null) {
                    val selectedImage: Uri? = data.data
                    val filePathColumn =
                        arrayOf(MediaStore.Images.Media.DATA)
                    if (selectedImage != null) {
                        val cursor: Cursor? = contentResolver.query(
                            selectedImage,
                            filePathColumn, null, null, null
                        )
                        if (cursor != null) {
                            cursor.moveToFirst()
                            val columnIndex: Int = cursor.getColumnIndex(filePathColumn[0])
                            val picturePath: String = cursor.getString(columnIndex)
                            imageViewLayout!!.setImageBitmap(BitmapFactory.decodeFile(picturePath))
                            cursor.close()
                        }
                    }
                }
            }
        }
    }

    // val SharedPreferences = "mPreferences"
    //val String sharedPrefFile = "tap.tap.RecipeKitchen.register"


}