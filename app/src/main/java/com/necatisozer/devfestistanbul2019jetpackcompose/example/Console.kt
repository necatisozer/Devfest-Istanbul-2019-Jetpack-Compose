package com.necatisozer.devfestistanbul2019jetpackcompose.example

fun main() {
    println("Hello World!")

    val n = 10
    for (i in 1..n) {
        for (j in 1..i) {
            print("*")
        }
        println()
    }
}