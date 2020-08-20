package com.example.movies.ui.details.similarview

data class Similars(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)