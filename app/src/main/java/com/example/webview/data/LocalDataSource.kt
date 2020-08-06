package com.example.webview.data

interface LocalDataSource {
    fun getLink(name: String): String?
    fun saveLink(name: String, link: String)
}