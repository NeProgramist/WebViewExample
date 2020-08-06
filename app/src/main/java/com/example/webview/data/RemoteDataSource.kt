package com.example.webview.data

import com.example.webview.domain.model.Result
import io.reactivex.rxjava3.core.Single

interface RemoteDataSource {
    fun getLinks(): Single<Result>
}