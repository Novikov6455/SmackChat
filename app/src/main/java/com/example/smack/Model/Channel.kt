package com.example.smack.Model

import com.example.smack.Services.UserDataService.name

class Channel(val name: String, val description: String, val id: String){
    override fun toString(): String {
        return "#$name"
    }
}