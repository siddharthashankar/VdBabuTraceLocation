package com.codingwithsid.tracelocation.network

import com.codingwithsid.tracelocation.models.RecyclerList
import com.codingwithsid.tracelocation.models.UserList
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    suspend fun getDataFromApi(@Query("q") query: String): RecyclerList


    @Headers( "x-api-key:HJsFLKNDP18PSadfAKYP83QtaSDqdDuI8MRo3l7y")
    @GET("Dev/users/")
    suspend fun getUserDataFromApi(): UserList
}