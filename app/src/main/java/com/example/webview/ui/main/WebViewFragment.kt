package com.example.webview.ui.main

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.webview.R
import kotlinx.android.synthetic.main.web_view_fragment.*

class WebViewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.web_view_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val link = arguments?.getString("link")
        with(webview) {
            setLayerType(View.LAYER_TYPE_HARDWARE, null);
            webChromeClient = WebChromeClient()
            webViewClient = WebViewClient()
            settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK;
            settings.setAppCacheEnabled(true)
            settings.setJavaScriptEnabled(true);
            loadUrl(link)
        }
    }
}
