package com.kotlin.submission2.data.repository.response.movies.cast

import com.google.gson.annotations.SerializedName

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
data class MoviesCastItem(

    @field:SerializedName("original_name")
    val originalName: String,

    @field:SerializedName("profile_path")
    val profilePath: String,

    @field:SerializedName("id")
    val id: Int

    )
