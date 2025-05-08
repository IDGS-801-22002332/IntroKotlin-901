package org.utl.introkotlin_901.temasKotlin

fun main(){
    println("Ingrese los valores necesarios para la formula general")
    println("Ingrese el valor de a")
    val a = readln().toDouble()
    println("Ingrese el valor de b")
    val b = readln().toDouble()
    println("Ingresa el valor de c")
    val c = readln().toDouble()

    val discriminant = b * b - 4 * a * c

    if (discriminant >= 0) {
        val x1 = (-b + Math.sqrt(discriminant)) / (2 * a)
        val x2 = (-b - Math.sqrt(discriminant)) / (2 * a)
        println("Las raices son: $x1 y $x2")
    } else {
        println("La ecuacion no tiene raices reales.")
    }


}