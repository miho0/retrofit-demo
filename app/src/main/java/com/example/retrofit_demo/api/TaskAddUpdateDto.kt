package com.example.retrofit_demo.api

import com.google.gson.annotations.SerializedName

data class TaskAddUpdateDto (
    @SerializedName("name") private val name: String,
    @SerializedName("description") private val description: String
)