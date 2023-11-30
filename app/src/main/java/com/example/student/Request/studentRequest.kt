package com.example.student.Request

import com.google.gson.annotations.SerializedName

data class StudentRequest(

	@field:SerializedName("name")
	var name: String? = null,

	@field:SerializedName("salary")
	var salary: String? = null,

	@field:SerializedName("age")
	var age: String? = null,
)
