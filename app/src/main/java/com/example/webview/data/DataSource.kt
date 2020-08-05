package com.example.webview.data

interface DataSource {
    fun getLinks()
    fun saveLink(name: String, link: String)
}