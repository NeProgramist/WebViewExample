package com.example.webview.domain.repository

import com.example.webview.data.DataSource
import com.example.webview.domain.repository.LinksRepository

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