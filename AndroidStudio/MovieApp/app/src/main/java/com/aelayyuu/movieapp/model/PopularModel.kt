package com.aelayyuu.movieapp.model

data class PopularModel(
    val page: Int,
    val results: List<ResultApi>,
    val total_pages: Int,
    val total_results: Int
)