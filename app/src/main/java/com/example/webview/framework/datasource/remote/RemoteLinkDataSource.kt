package com.example.webview.framework.datasource.remote

import com.example.webview.data.RemoteDataSource
import com.example.webview.domain.model.Result
import com.google.gson.Gson
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class RemoteLinkDataSource: RemoteDataSource {
    override fun getLinks(): Single<Result> {
        val client = OkHttpClient()
        val request = Request
            .Builder()
            .url("https://efs5i1ube5.execute-api.eu-central-1.amazonaws.com/prod")
            .build()

        return Single.create {
            try {
                val response = client.newCall(request).execute()
                val result = Gson().fromJson(response.body?.string(), Result::class.java)
                it.onSuccess(result)
            } catch(e: Exception) {
                it.onError(e)
            }
        }
    }
}