package com

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class PrefsUtil {

    companion object {
        private var sharedPrefs: SharedPreferences? = null
        private const val SHARED_PREFS_NAME = "MySharedPrefs"

        fun initPrefs(context: Context) {
            sharedPrefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        }

        @SuppressLint("CommitPrefEdits")
        fun setPrefs(username: String, password: String) {
            sharedPrefs?.apply {
                edit().putString("username", username)
                edit().putString("password", password)
            }
        }

        fun getPrefsUsername(): String? {
            return sharedPrefs?.getString("username", null)
        }

        var isLoggedIn
            get() = sharedPrefs?.getBoolean("isLoggedIn", false) ?: false
            set(value) {
                sharedPrefs?.edit()?.putBoolean("isLoggedIn", value)?.apply()
            }

    }

}