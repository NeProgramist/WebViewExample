package com.example.webview.ui.splash

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.webview.domain.interactor.GetLinkUseCase
import com.example.webview.domain.repository.LinksRepositoryImpl
import com.example.webview.framework.datasource.local.LocalLinkDataSource
import com.example.webview.framework.datasource.remote.RemoteLinkDataSource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class SplashViewModel(application: Application) : AndroidViewModel(application) {
    val link = MutableLiveData<String>()

    fun getLink() {
        GetLinkUseCase(
            LinksRepositoryImpl(
                LocalLinkDataSource(getApplication()),
                RemoteLinkDataSource()
            )
        )()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                { link.value = it; Log.e("asdfasdf", "here") },
                { Log.e("asdfasdf", "An error occurred - $it") }
            )
    }
}
