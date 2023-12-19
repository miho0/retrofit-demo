package com.example.retrofit_demo.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TaskApi {
    @GET("task")
    fun getTasks(): Call<MutableList<TaskDto>>
    @POST("task")
    fun addTask(@Body task: TaskAddUpdateDto): Call<TaskDto>
    @PUT("task/{id}")
    fun editTask(@Path("id") id:String, @Body task: TaskAddUpdateDto): Call<Unit>
    @DELETE("task/{id}")
    fun deleteTask(@Path("id") id: String): Call<Unit>

}