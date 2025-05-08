package org.utl.introkotlin_901.temasKotlin

//For
fun main(){
    for(number in 1..5){
    print(number)
    }

    val nombres= listOf("Ronald","Luis","Rosa","Mario")
    for(nombre in nombres){
        println(nombre)
    }

    //while do-while
    var x = 0
    while (x < 5){
        println(x)
        x++
    }

    do{
        println(x)
        x++
    }while(x < 5)
}
