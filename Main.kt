import kotlin.random.Random

const val MOSCA=1
const val TAMANIO =5
const val VACIO = 0
//expresión de elvis
//x = readLine()?.toIntOrNull() ?:

fun main(args: Array<String>) {
    var tablero=inicializarTablero(TAMANIO)
    imprimirTablero(tablero)
    var estaMuerta = false
do {

    var tirada = pedirCasilla(TAMANIO)
    var x = tirada[0]
    var y = tirada[1]
    var casillaX = 0
    var casillaY = 0
    var i = -1

    if (tablero[x][y] == MOSCA) {
        println("Muerta")
        estaMuerta = true
    } else {
        while (i <= 1) {
            var j = -1
            while (j <= 1) {
                casillaX = x + i
                casillaY = y + j
                if (casillaX >= 0 && casillaX < TAMANIO && casillaY >= 0 && casillaY < TAMANIO) {
                    if (tablero[casillaX][casillaY] == MOSCA) {
                        println("Me largo")
                        tablero = inicializarTablero(TAMANIO)
                    }
                }
                j++
            }
            i++
        }

    }

    //comprobar(tablero,tirada)
}while(!estaMuerta)
}
fun comprobar(t:Array<IntArray>,m:IntArray){




}
fun pedirCasilla(tamanio:Int):IntArray{
    var v=IntArray(2){0}

    do{
        println("Dame la X")
       v[0] = readln().toIntOrNull() ?:-1
    }while(v[0]<0 || v[0]>tamanio)
    do{
        println("Dame la Y")
        v[1] = readln().toIntOrNull() ?:-1
    }while(v[1]<0 || v[1]>tamanio)

    return v
}
fun inicializarTablero(tamanio:Int):Array<IntArray>{
    var m=Array(tamanio){IntArray(tamanio){VACIO}}
    var x = Random.nextInt(0,tamanio)
    var y = Random.nextInt(0,m.size)
    m[x][y]=MOSCA
    return m
}
fun imprimirTablero(t:Array<IntArray>){

    for(i in t.indices){
        for(j in t.indices){
            print(t[i][j])

        }
        println()
    }
}