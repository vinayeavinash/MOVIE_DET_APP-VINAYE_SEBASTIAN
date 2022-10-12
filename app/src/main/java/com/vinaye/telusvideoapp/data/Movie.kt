package com.vinaye.telusvideoapp.data


import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("errorDescription")
    val errorDescription: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("resultCode")
    val resultCode: String,
    @SerializedName("resultObj")
    val resultObj: ResultObj,
    @SerializedName("systemTime")
    val systemTime: Long
)