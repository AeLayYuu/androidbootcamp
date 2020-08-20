package com.aelayyuu.something.model.similarview

data class Similars(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)