package com.example.student.Api

import com.example.student.Request.StudentRequest
import com.example.student.Response.EmployeeResponse
import com.example.student.Response.StudentResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("employee/1") // Replace with your API endpoint
    fun getPost(): Call<EmployeeResponse>

    @POST("create")
    fun postData(@Body StudentRequest : StudentRequest): Call<StudentResponse>
}