package com.example.news_app.models

data class NewResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)