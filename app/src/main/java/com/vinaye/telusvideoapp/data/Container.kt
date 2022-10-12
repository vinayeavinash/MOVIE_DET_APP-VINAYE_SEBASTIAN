package com.vinaye.telusvideoapp.data


import com.google.gson.annotations.SerializedName

data class Container(
    @SerializedName("id")
    val id: String,
    @SerializedName("layout")
    val layout: String,
    @SerializedName("metadata")
    val metadata: Metadata
)