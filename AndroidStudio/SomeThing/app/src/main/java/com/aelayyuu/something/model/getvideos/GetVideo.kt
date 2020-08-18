package com.aelayyuu.something.model.getvideos

data class GetVideo(
    val id: Int,
    val results: List<GetResult>
)