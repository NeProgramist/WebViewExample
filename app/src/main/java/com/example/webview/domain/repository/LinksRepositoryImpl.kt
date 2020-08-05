package com.example.webview.domain.repository

import com.example.webview.data.LocalDataSource
import com.example.webview.data.RemoteDataSource

class LinksRepositoryImpl(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource
): LinksRepository {
    override fun getLinks() {
        val local = local.getLink("")
        if (local == null) {
            val remote = remote.getLinks()

        }
    }

    private fun saveLink(name: String, link: String) {
        local.saveLink(name, link)
    }
}