package com.example.smack.Tests.Controller

import android.app.Application
import com.example.smack.Utilities.SharedPrefs

class App : Application() {
    companion object {
        lateinit var prefs: SharedPrefs
    }

    override fun onCreate() {
        prefs = SharedPrefs(applicationContext)
        super.onCreate()
    }
}