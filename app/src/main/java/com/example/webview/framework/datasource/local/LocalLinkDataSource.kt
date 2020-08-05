package com.example.webview.framework.datasource.local

import android.app.Application
import android.content.Context
import androidx.preference.PreferenceManager
import com.example.webview.data.DataSource

class LocalLinkDataSource(
    context: Context
): DataSource {
    private val preference = PreferenceManager.getDefaultSharedPreferences(context)

    override fun getLinks(name: String) {

    }

    override fun saveLink(name: String, link: String) {
        preference
            .edit()
            .putString(name, link)
            .apply()
    }

}