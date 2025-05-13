package org.utl.introkotlin_901.temasKotlin

class Circulo(val radio: Double) {
    fun calcularArea(): Double {
        return 3.1415 * radio * radio
    }
}

class Cuadrado(val lado: Double) {
    fun calcularArea(): Double {
        return lado * lado
    }
}

class Pentagono(val lado: Double, val apotema: Double) {
    fun calcularArea(): Double {
        val perimetro = lado * 5
        return (perimetro * apotema) / 2
    }
}

class Triangulo(val base: Double, val altura: Double) {
    fun calcularArea(): Double {
        return (base * altura) / 2
    }
}

fun main() {
    var opcion = 0

    while (opcion != 5) {
        println("\nElija la opcion para calcular el area:")
        println("1. Circulo")
        println("2. Cuadrado")
        println("3. Pentagono")
        println("4. Triangulo")
        println("5. Salir")

        opcion = readln().toInt()

        if (opcion == 1) {
            println("Ingrese el radio del circulo:")
            val radio = readln().toDouble()
            val c = Circulo(radio)
            println("El area del circulo es: ${c.calcularArea()}")
        } else if (opcion == 2) {
            println("Ingrese el lado del cuadrado:")
            val lado = readln().toDouble()
            val c = Cuadrado(lado)
            println("El area del cuadrado es: ${c.calcularArea()}")
        } else if (opcion == 3) {
            println("Ingrese el lado del pentagono:")
            val lado = readln().toDouble()
            println("Ingrese la apotema del pentagono:")
            val apotema = readln().toDouble()
            val p = Pentagono(lado, apotema)
            println("El area del pentágono es: ${p.calcularArea()}")
        } else if (opcion == 4) {
            println("Ingrese la base del triangulo:")
            val base = readln().toDouble()
            println("Ingrese la altura del triangulo:")
            val altura = readln().toDouble()
            val t = Triangulo(base, altura)
            println("El area del triangulo es: ${t.calcularArea()}")
        } else if (opcion == 5) {
            println("Saliendo")
        } else {
            println("Opcion no valida")
        }
    }
}
