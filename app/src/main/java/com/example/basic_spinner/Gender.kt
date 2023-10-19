package com.example.basic_spinner

data class Gender(
    var sex:String,
    var value:String
){
    override fun toString(): String {
        return sex
    }
}
