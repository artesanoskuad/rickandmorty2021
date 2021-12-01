package com.example.app.feature.location.data.model

data class Location(
    val id : Int,
    val name : String,
    val type : String,
    val dimension : String,
    val residents : List<String>,
    val url : String,
    val created: String
)
