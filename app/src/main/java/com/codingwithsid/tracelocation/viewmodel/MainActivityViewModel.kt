package com.codingwithsid.tracelocation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithsid.tracelocation.models.RecyclerList
import com.codingwithsid.tracelocation.network.RetroService
import com.codingwithsid.tracelocation.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    lateinit var recyclerListLiveData: MutableLiveData<RecyclerList>

    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver(): MutableLiveData<RecyclerList> {
        return recyclerListLiveData
    }

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
           val retroInstance =  RetrofitInstance.getRetrofitInstance().create(RetroService::class.java)
           val response =  retroInstance.getDataFromApi("ny")
            Log.i("Response--",response.toString())
            recyclerListLiveData.postValue(response)
        }
    }
}