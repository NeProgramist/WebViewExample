package com.example.webview.domain.repository

import io.reactivex.rxjava3.core.Single

interface LinksRepository {
    fun getLinks(): Single<String>
}
