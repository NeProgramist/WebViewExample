package com.example.webview.framework.datasource.local

import android.content.Context
import androidx.preference.PreferenceManager
import com.example.webview.data.LocalDataSource
import io.reactivex.rxjava3.core.Single

class LocalLinkDataSource(
    context: Context
): LocalDataSource {
    private val preference = PreferenceManager.getDefaultSharedPreferences(context)

    override fun getLink(name: String): String? = preference.getString(name, null)
    override fun saveLink(name: String, link: String) {
        preference
            .edit()
            .putString(name, link)
            .apply()
    }
}