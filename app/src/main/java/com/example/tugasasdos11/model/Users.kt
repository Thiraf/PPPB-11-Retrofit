package com.example.tugasasdos11.model

import com.google.gson.annotations.SerializedName

data class Users(

    @SerializedName("data")
    var data: List<Data>
)
