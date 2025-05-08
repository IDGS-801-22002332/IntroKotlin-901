package org.utl.introkotlin_901.temasKotlin

fun main(){
    println("Ingresa el tamano de la piramide")
    val num = readln().toInt()

    if (num>0){
        var fila=1
        do{
            var asteriscos=1
            while(asteriscos <= fila){
                print("*")
                asteriscos++
            }
            println()
            fila++
        }while (fila <=num)
    }
}
