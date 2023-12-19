package com.example.retrofit_demo.api

import com.google.gson.annotations.SerializedName


data class TaskDto(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String
)
