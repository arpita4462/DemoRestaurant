package com.gmediasolutions.demorestaurant.model

data class SignUpModel(
        val emailId:String,
        val firstName: String,
        val lastName: String,
        val password: String,
        val confirmPassword:String

)