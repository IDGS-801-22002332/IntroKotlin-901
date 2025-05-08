package org.utl.introkotlin_901.temasKotlin

fun main(){
    var opcion=0

    while (opcion !=5) {
        println("Elija la opcion que desea calcular el area")
        println("1. Circulo")
        println("2. Cuadrado")
        println("3. Pentagono")
        println("4. Triangulo")
        println("5. Salir")

        opcion = readln().toInt()

        if (opcion == 1) {
            println("Ingrese el radio del circulo")
            val radio = readln().toDouble()
            val area = 3.1415 * radio * radio
            println("El area del circulo es ${area}")
        } else if (opcion == 2) {
            println("Inhresa el lado del cuadrado")
            val lado = readln().toDouble()
            val area = lado * lado
            println("El area del cuadrado es ${area}")
        } else if (opcion == 3) {
            println("Ingresa el lado del pentagono")
            val lado= readln().toDouble()
            val perimetro = lado * 5
            println("Ingresa la apotema del pentagono")
            val apotema = readln().toDouble()
            val area = (perimetro * apotema) / 2
            println("El area del pentagono es ${area}")
        } else if (opcion == 4) {
            println("Ingresa la base del triangulo")
            val base = readln().toDouble()
            println("Ingresa la altura del triangulo")
            val altura = readln().toDouble()
            val area = (base * altura) / 2
            println("El area del triangulo es ${area}")
        }else if (opcion ==5){
            println("Saliendo")
        }
    }
}