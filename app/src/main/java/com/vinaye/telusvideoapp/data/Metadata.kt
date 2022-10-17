package com.vinaye.telusvideoapp.data


import com.google.gson.annotations.SerializedName

data class Metadata(
    @SerializedName("contentId")
    val contentId: Int,
    @SerializedName("contentSubtype")
    val contentSubtype: String,
    @SerializedName("contentType")
    val contentType: String,
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("iconicImage169")
    val iconicImage169: String,
    @SerializedName("iconicImage23")
    val iconicImage23: String,
    @SerializedName("image169")
    val image169: String,
    @SerializedName("image23")
    val image23: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("longDescription")
    val longDescription: String,
    @SerializedName("pcLevel")
    val pcLevel: Int,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("year")
    val year: String
)