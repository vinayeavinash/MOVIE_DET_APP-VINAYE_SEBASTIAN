package com.vinaye.telusvideoapp.data


import com.google.gson.annotations.SerializedName

data class ResultObj(
    @SerializedName("containers")
    val containers: List<Container>,
    @SerializedName("total")
    val total: Int
)