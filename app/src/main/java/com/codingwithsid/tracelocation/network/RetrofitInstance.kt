package com.codingwithsid.tracelocation.network

import com.codingwithsid.tracelocation.utils.Util.BaseURL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object{


        fun getRetrofitInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}