package com.example.webview.framework.datasource.remote

import com.example.webview.data.DataSource

class LinksRepositoryImpl(
    private val local: DataSource,
    private val remote: DataSource
): LinksRepository {
    override fun getLinks() {
        val local = local.getLinks()
        if (local == null) {
            val remote = remote.getLinks()
        }
    }

    private fun saveLink(name: String, link: String) {
        local.saveLink(name, link)
    }
}