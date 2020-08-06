package com.example.webview.domain.repository

import com.example.webview.common.Links
import com.example.webview.data.LocalDataSource
import com.example.webview.data.RemoteDataSource
import io.reactivex.rxjava3.core.Single

class LinksRepositoryImpl(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource
): LinksRepository {

    override fun getLinks(): Single<String> {
        val local = local.getLink(Links.HOME.key)
        return if (local == null) {
            remote
                .getLinks()
                .doOnSuccess { saveLink(Links.HOME.key, it.home) }
                .map { it.link }
        } else {
            Single
                .create { it.onSuccess(local) }
        }
    }

    private fun saveLink(name: String, link: String) = local.saveLink(name, link)
}
