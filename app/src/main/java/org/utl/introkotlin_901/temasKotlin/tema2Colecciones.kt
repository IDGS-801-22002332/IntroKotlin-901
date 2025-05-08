package org.utl.introkotlin_901.temasKotlin

fun main(){

    /*
     List, mutableList
     Set, MutableSet
     Map, MutableMap
     */

    var readOnlyList:List<String> = listOf("Lunes", "Martes","Miercoles","Jueves", "Viernes", "Sabado", "Domingo")
    println(readOnlyList)
    println("el primer dia es ${readOnlyList[0]}")
    println("el primer dia es ${readOnlyList.first()}")
    println("El numero de dias es: ${readOnlyList.count()}")
    println("El numero de dia es: ${readOnlyList.size}")
    println("Martes" in readOnlyList)
    var figuras:MutableList <String> = mutableListOf("Circulo", "Cuadrado", "Triangulo")
    println(figuras)
    figuras.add("Pentagono")
    println(figuras)
    figuras.removeAt(0)
    println(figuras)
    figuras.remove("Cuadrado")
    println(figuras)

//--------------------------------------------------------------------------------------------------

    val readonlyFrutas = mapOf("Manzana" to 1500, "Platano" to 2000, "Sandia" to 2500)
    println(readonlyFrutas)
    println(readonlyFrutas["Manzana"])
    println(readonlyFrutas.keys)
    println(readonlyFrutas.values)
}