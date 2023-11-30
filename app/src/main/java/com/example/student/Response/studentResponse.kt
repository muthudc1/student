package com.example.student.Response

import com.google.gson.annotations.SerializedName

data class StudentResponse(

	@field:SerializedName("data")
	val data: stu? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class stu(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("salary")
	val salary: String? = null,

	@field:SerializedName("age")
	val age: String? = null
)
