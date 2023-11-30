package com.example.student.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.student.Api.RetrofitClient.apiService
import com.example.student.Response.EmployeeResponse
import com.example.student.databinding.ActivityViewBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class view : AppCompatActivity() {
    lateinit var  binding: ActivityViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val call: Call<EmployeeResponse> = apiService.getPost()
        call.enqueue(object : Callback<EmployeeResponse> {
            override fun onResponse(call: Call<EmployeeResponse>, response: Response<EmployeeResponse>) {
                if (response.isSuccessful) {
                    val post: EmployeeResponse? = response.body()

                    val id = post!!.data!!.id.toString()
                    val name  = post.data!!.employeeName.toString()
                    val salary = post.data.employeeSalary.toString()
                    val age = post.data.employeeAge.toString()

//                    if (post.data.profileImage == null)
//                    {
//                        Toast.makeText(this@view, "null", Toast.LENGTH_SHORT).show()
//
//                    }
//                    else
//                    {
//                        val profileImage = post.data.profileImage.toString()
//
//                        Picasso.with(this@view).load(profileImage).into(binding.profileImage)
//                    }


                    binding.id.text  = id
                    binding.employeename.text = name
                    binding.employeesalary.text = salary
                    binding.employeeage.text = age

//                    binding.thumbnail.setImageResource(thumbnail!!)

                    Toast.makeText(this@view, "name : $name", Toast.LENGTH_SHORT).show()


                } else {
                    Toast.makeText(this@view, "error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                // Handle failure
                Toast.makeText(this@view, "Api error"+t.message.toString(), Toast.LENGTH_SHORT).show()

            }
        })
    }
}


