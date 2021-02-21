package com.codingwithsid.tracelocation.models

data class UserList(val items: ArrayList<String>)

data class RecyclerList(val items: ArrayList<RecyclerData>)
data class RecyclerData(val name: String, val description: String, val owner: Owner)
data class Owner(val avatar_url: String)