package com.example.webview.ui.splash

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.webview.R
import com.example.webview.ui.MainActivity
import kotlinx.android.synthetic.main.splash_fragment.*

class SplashFragment : Fragment() {
    private lateinit var viewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.splash_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        viewModel.link.observe(viewLifecycleOwner, Observer { link ->
            val data = bundleOf("link" to link)
            (activity as MainActivity)
                .navController
                .navigate(R.id.action_splashFragment_to_webViewFragment, data)
        })
    }

    override fun onResume() {
        super.onResume()
        /* Just to show that splash screen works */
        Handler().postDelayed({
            viewModel.getLink()
        }, 4000)
    }
}
