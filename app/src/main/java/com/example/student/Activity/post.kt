package com.example.student.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.student.Api.RetrofitClient
import com.example.student.Request.StudentRequest
import com.example.student.Response.StudentResponse
import com.example.student.databinding.ActivityPostBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class post : AppCompatActivity() {

    lateinit var  binding: ActivityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.submit.setOnClickListener {


            var name = binding.name.text.toString()
            var salary = binding.salary.text.toString()
            var age = binding.age.text.toString()
            var logReq = StudentRequest()

            logReq.name = name
            logReq.salary = salary
            logReq.age = age

// Call the postData method using the Retrofit service
            val call = RetrofitClient.apiService.postData(logReq)

// Execute the call asynchronously
            call.enqueue(object : Callback<StudentResponse> {
                override fun onResponse(call: Call<StudentResponse>, response: Response<StudentResponse>) {
                    if (response.isSuccessful) {
                        // Handle the successful response here
                        val responseData : StudentResponse? = response.body()
                        val id  = responseData!!.data!!.id.toString()
                        val name  = responseData!!.data!!.name.toString()
                        val salary  = responseData!!.data!!.salary.toString()
                        val age  = responseData!!.data!!.age.toString()

                        // Do something with the response data
                        binding.tv.text = "id : $id ,name : $name, salary: $salary ,age : $age"

                    } else {
                        // Handle the error response here
                        // You can get more details about the error from response.errorBody()
                        Toast.makeText(this@post, "some thing went wrong", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                    // Handle the network or unexpected errors here
                    Toast.makeText(this@post, ""+t.message, Toast.LENGTH_SHORT).show()

                }
            })






        }
    }
}