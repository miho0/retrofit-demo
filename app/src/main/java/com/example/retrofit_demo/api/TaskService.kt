package com.example.retrofit_demo.api

import android.util.Log
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TaskService {
    companion object RetrofitClient {
        private const val BASE_URL = "https://crudcrud.com/api/012d383fc0f84199bce8ad42f23c67b8/"
        fun getClient(): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
    }

    private val taskApi = getClient().create(TaskApi::class.java)

    fun getTasks(callback: (MutableList<TaskDto>?) -> Unit) {
        taskApi.getTasks().enqueue(object : Callback<MutableList<TaskDto>> {
            override fun onResponse(call: Call<MutableList<TaskDto>>, response: Response<MutableList<TaskDto>>) {
                if (response.isSuccessful) {
                    val tasks: MutableList<TaskDto>? = response.body()
                    callback(tasks)
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<MutableList<TaskDto>>, t: Throwable) {
                Log.e("API_CALL_ERROR", "Failed API call", t)
                callback(null)
            }
        })
    }

    fun addTask(task: TaskAddUpdateDto) {
        taskApi.addTask(task).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (!response.isSuccessful) {
                    val errorBody = response.errorBody()?.string()
                    Log.e("ERROR", errorBody.toString())
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.e("API_CALL_ERROR", "Failed API call", t)
            }
        })
    }

    fun updateTask(id: String, task: TaskAddUpdateDto) {
        taskApi.editTask(id, task).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (!response.isSuccessful) {
                    val errorBody = response.errorBody()?.string()
                    Log.e("ERROR", errorBody.toString())
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.e("API_CALL_ERROR", "Failed API call", t)
            }
        })
    }

    fun deleteTask(taskId: String, callback: (Boolean) -> Unit) {
        taskApi.deleteTask(taskId).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    callback(true)
                } else {
                    Log.e("DELETE_API_CALL_ERROR", "Failed DELETE API call: ${response.code()}")
                    callback(false)
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.e("DELETE_API_CALL_ERROR", "Failed DELETE API call", t)
                callback(false)
            }
        })
    }

}