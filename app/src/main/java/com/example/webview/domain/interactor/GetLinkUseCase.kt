package com.example.webview.domain.interactor

import com.example.webview.domain.repository.LinksRepository

class GetLinkUseCase(private val repository: LinksRepository) {
    operator fun invoke() = repository.getLinks()
}
