package com.example.webview.data

interface DataSource {
    fun getLinks(name: String)
    fun saveLink(name: String, link: String)
}