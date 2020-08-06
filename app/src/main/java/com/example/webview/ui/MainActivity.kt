package com.example.webview.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.webview.R
import kotlinx.android.synthetic.main.web_view_fragment.*

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host)
    }

    override fun onBackPressed() {
        if (webview.visibility == View.VISIBLE) {
            if (webview.canGoBack()) webview.goBack()
            return
        } else {
            super.onBackPressed()
        }
    }
}
