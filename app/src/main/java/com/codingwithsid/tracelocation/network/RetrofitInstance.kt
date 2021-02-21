package com.codingwithsid.tracelocation.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object{
        val BaseURL = "https://api.github.com/search/"
      //  val BaseURL = "https://io2xk2ntr8.execute-api.us-east-2.amazonaws.com/"

        fun getRetrofitInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}