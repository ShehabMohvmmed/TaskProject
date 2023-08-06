package com

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import com.cheesecake.taskproject.R
import android.app.AlertDialog
import android.content.DialogInterface
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etUsername: EditText = findViewById(R.id.et_username)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val cbFootball: CheckBox = findViewById(R.id.cbFootball)
        val cbBasketball: CheckBox = findViewById(R.id.cbBasketball)
        val cbVolleyball: CheckBox = findViewById(R.id.cbVolleyball)
        val radioGroupGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val btnRegister: Button = findViewById(R.id.btn_register)

        val intent = intent
        val loginMethod = intent.getStringExtra(MainActivity.EXTRA_SELECTED_LOGIN_METHOD)
        if (loginMethod != null) {
            val toastMessage = "Logged in by: $loginMethod"
            Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show()
        }

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            val selectedSports = StringBuilder()
            if (cbFootball.isChecked) {
                selectedSports.append("Football, ")
            }
            if (cbBasketball.isChecked) {
                selectedSports.append("Basketball, ")
            }
            if (cbVolleyball.isChecked) {
                selectedSports.append("Volleyball, ")
            }

            val selectedGender = when (radioGroupGender.checkedRadioButtonId) {
                R.id.rbMale -> "Male"
                R.id.rbFemale -> "Female"
                else -> "unknown"
            }

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(EXTRA_USERNAME, username)
            intent.putExtra(EXTRA_PASSWORD, password)
            intent.putExtra(EXTRA_SELECTED_SPORTS, selectedSports.dropLast(2).toString())
            intent.putExtra(EXTRA_SELECTED_GENDER, selectedGender)
            startActivity(intent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_second_activity -> openSecondActivity()
            R.id.menu_item_exit -> showExitConfirmationDialog()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    private fun showExitConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exit Application")
        builder.setMessage("Are you sure you want to exit?")
        builder.setPositiveButton("Yes") { _: DialogInterface, _: Int ->
            finish()
        }
        builder.setNegativeButton("No") { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_PASSWORD = "extra_password"
        const val EXTRA_SELECTED_SPORTS = "extra_selected_sports"
        const val EXTRA_SELECTED_GENDER = "extra_selected_gender"
        const val EXTRA_SELECTED_LOGIN_METHOD = "extra_selected_login_method"
    }
}