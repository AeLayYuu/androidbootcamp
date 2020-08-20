package com.example.movies.ui.details.biographyview

data class Biography(
    val adult: Boolean,
    val also_known_as: List<Any>,
    val biography: String,
    val birthday: String,
    val deathday: Any,
    val gender: Int,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val known_for_department: String,
    val name: String,
    val place_of_birth: String,
    val popularity: Double,
    val profile_path: String
)