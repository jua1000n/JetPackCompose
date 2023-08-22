package com.kukis.cursojetpack.navigation.model

sealed class Routes(val route: String) {
    object Pantalla1 : Routes("pantalla1")
    object Pantalla2 : Routes("pantalla2")
    object Pantalla3 : Routes("pantalla3")
    object Pantalla4 : Routes("pantalla4?={name}") {
        fun createRoute(name: String?) = "pantalla4?=$name"
}
    object Pantalla5 : Routes("pantalla5/{age}") {
        fun createRoute(age: Int) = "pantalla5/$age"
    }
}