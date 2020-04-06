package com.example.appclima

class Ciudad(nombre:String, grados:Int, estatus:String) {
    var name: String = ""
    var weather: ArrayList<Weather>? = null
    var main: Main? = null

    init {
        this.name = name
        this.weather = weather
        this.main  = main
    }
}