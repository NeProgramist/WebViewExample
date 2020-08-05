package com.example.webview.framework.datasource.local

import android.content.Context
import androidx.preference.PreferenceManager
import com.example.webview.data.LocalDataSource

class LocalLinkDataSource(
    context: Context
): LocalDataSource {
    private val preference = PreferenceManager.getDefaultSharedPreferences(context)

    override fun getLink(name: String) {

    }

    override fun saveLink(name: String, link: String) {
        preference
            .edit()
            .putString(name, link)
            .apply()
    }
}