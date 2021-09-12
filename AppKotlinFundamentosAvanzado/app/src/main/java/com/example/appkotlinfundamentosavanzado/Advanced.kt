package com.example.appkotlinfundamentosavanzado

import java.lang.Exception
import java.util.*

private var nullStrGlobal:String? = null

private lateinit var lateInitGlobal: String // Esta por cojones tiene que ser VAR no vale VAL porque son modificables
private val lazyGlobal: Any by lazy { "gLazyKotlin" } // Esto solo vale para VAL porque son solo para LECTURAS

fun main() {
    // METODOS DE STRING
    topic("MÉTODOS DE STRING")
    val course = "Kotlin course by Cursos Android ANT"
    val target = "Android"
    println(course.length)
    println(course.compareTo(target)) // Este metodo se utiliza para comparar el orden alfabético ( entre la A y la K hay 10 posiciones )
    println(course.equals(target))
    println(course.contains(target)) // el contains tiene que ser exactamente igual
    println(course.lowercase())
    println(course.uppercase())
    println(course.subSequence(0, 6))
    println(course.indexOf("n"))
    val empty = ""
    println(empty.isBlank())
    println(empty.isEmpty())
    println(course.lastIndexOf("n"))
    println(course.lowercase().lastIndexOf("n"))
    println(course.replace("c", "k"))
    println(course.lowercase().replace("an", "os"))
    println(course.replaceBefore("by", "only "))
    println(course.reversed()) // solo da la vuelta a t_odo, también vale para los arrays
    println(course.slice(20 until course.length))
    println(course.split("y"))
    println(course.startsWith("K"))
    println(course.substring(14, 16))
    println(course.substring(course.lastIndexOf("A")))
    println(course.trim())


    topic("NULL SAFETY")
    subtopic("?")
    var nullStr:String? = null
    println(nullStr)
    nullStr = "hola"
    println(nullStr.get(0))
    println(nullStrGlobal?.reversed())

    subtopic("!!")
    nullStr = null
    showMessage(nullStr)
    nullStrGlobal = null //"Android"
    showMessage("Kotlin")


    // Elvis operator ?:
    topic("Operador Elvis")
    val elvis = nullStrGlobal ?: "Java" // Es como un if else, si en el caso de que el primero no sea nulo lo devuelve, si no pues coje el otro de la derecha
    println("Yo programo en $elvis")

    // Ahora vemos commo se hace sin el operador elvis ( todo esto se soluciona con el operador elvis )
    val noElvis = if(nullStrGlobal != null) {
        nullStrGlobal
    } else {
        "Java"
    }
    println("Yo programo en $noElvis")


    // READ LINE
    topic("READLINE")
    println("Insesrte un número")
    val first = readLine()
    val a = first!!.toInt()
    println("a = $a")
    println("Insesrte otro número")
    val second = readLine()
    val b = second!!.toInt()
    println("b = $b")


    // OPERADORES MATEMATICOS
    topic("OPERADORES MATEMATICOS")
    println("a + b = ${a + b}")
    println("a - b = ${a - b}")
    println("a * b = ${a * b}")
    println("a / b = ${a / b}")
    println("a  b = ${a + b}")

    // SMART CAST
    topic("SMARTCAST")
    var obj:Any = "Kotlin Course"
    // obj = 3
    //println(obj.toString().toInt() * b)
    var objNum: Any = "3D"
    if(objNum is Int) {
        println("objNum es un número")
        println(objNum.toString().toInt() * b)
    } else {
        println("ObjNum no es número")
    }


    // TRY CATCH FINALLY
    topic("TRY CATCH FINALLY")
    obj = 3
    try {
        println(obj.toString().toInt() * b)
        println("obj es un número y esta es la ultima linea del try")
    } catch (e:Exception) {
        println(e)
        println("Mensaje personalizaddo para el error en catch")
    } finally {
        println("Try catch finalizado")
    }


    // UNSAFE CAST & SAFE CAST
    topic("UNSAFE CAST & SAFE CAST")
    subtopic("UNSAFE CAST")
    obj = "true"
    val unsafeStr: String = obj as String
    println(unsafeStr)

    subtopic("SAFE CAST")
    obj = true
    val safeStr = obj as? String
    println(safeStr)


    // THROW
    topic("THROW")
    val job = "Designer"
    checkType(job)
    try {
        checkType(b)
    } catch (e: Exception) {
        println(e)
    } finally {
        println("Se termina la tarea con exito")
    }


    // INFIX
    topic("INFIX")
    val name = "Android"
    println(name.uppercase())
    println(name.lowercase())
    println(name)
    println(name.toMixCase(true))
    println(name.toMixCase(false))

    // LAZY & LATEINIT
    topic("LAZY & LATEINIT")

    subtopic("LATEINIT")
    // ESTO SOLO SE PUEDE APLICAR A VARIABLES GLOBALES
    if(setValueForLateInit()) {
        println(lateInitGlobal)
        println(lateInitGlobal.toMixCase(true))
    }

    subtopic("LAZY")
    println(lazyGlobal)


    // SCOPE FUNCTIONS
    topic("FUNCIONES DE ALCANCE")

    // WITH
    subtopic("WITH") // CON ESTE OBJETO, HAZ ALGO
    var highSchool = HighSchool("Stan", "Calle Independencia #22", null)
    with(highSchool) {
        println(addres)
    }

    // APPLY
    subtopic("APPLY") // APLICA LAS SIGUIENTES CONFIRGURACIONES ( PROPIEDADES )
    highSchool.apply { // ESTO SOLO SE RECOMIENDA PARA ASIGNAR PROPIEDADES
        firstName = "Ahora se llama así"
    }

    println(highSchool.firstName)
    println("Valores asignados correctamente con apply")

    // RUN
    subtopic("RUN") // EJECUTA EL SIGIUENTE BLOQUE
    highSchool.run { // EN ESTA FUNCION SI PODEMOS ASINGAR PROPIEDADES AL OBJETO Y LLAMAR METODOS A SU VEZ
        println("Ejecuta el siguiente bloque de codigo en el objeto")

    }

    // LET
    subtopic("LET") // PERMITE EJECUTAR UN BLOQUE DE CODIGO A UN OBJETO NO NULL ( VERIFICADO CON ? )
    var school: HighSchool? = null
    school = createSchool()
    school?.let { // SE RECOMIENDA USAR ESTA FUNCION PARA EJECUTAR UN BLOQUE DE CODIGO CUANDO EL OBJETO NO ES NULO ( PARA ESO SE USA EL SIGNO DE INTERROGACIÓN PARA COMPROBAR QUE NO SEA NULO )
        println("Si el objeto es diferente de null, permite imprimirlo: $it")
    }

    // ALSO
    subtopic("ALSO") // Y ADEMÁS EJECUTA EL SIGUIENTE CODIGO
    val udemy: HighSchool
    udemy = HighSchool("a", "b", null).apply {
        firstName = "NUEVO NOMBRE".also {
            println("y también, notifica que el nombre de la escuela nueva es $it")
        }
    }



}

private fun createSchool(): HighSchool? = HighSchool("Stan", "Calle Independencia #22", null) // null

class HighSchool (var firstName:String, var addres:String, var persons:MutableList<String>?)

private fun setValueForLateInit(): Boolean {

    lateInitGlobal = "gLateInitKotlin"
    return lateInitGlobal.isNotEmpty()
}

private infix fun String.toMixCase(firstUpper: Boolean):String {
    var mixString = ""
    var index = 0
    var module = 0

    if(firstUpper) {
        this.uppercase()
    } else {
        this.lowercase()
        module = 1
    }

    while (index < this.length) {
        if(index % 2 == module) {
            mixString += this.get(index).uppercase()
        } else {
            mixString += this.get(index).lowercase()
        }
        index++
    }

    return mixString
}

private fun checkType(value: Any) {
    if(value is String) {
        println("String valido")
    } else {
        throw TypeCastException("No es un string")
    }

}

private fun showMessage(message:String?) {
    println("? ${message?.get(0)}")

    if (message != null) {
        println("! ${message.get(0)}")
    }

    if (nullStrGlobal != null ) {
        println("g!! ${nullStrGlobal!!.get(0)}")
    }

    //println("g!! ${nullStrGlobal!!.get(0)}")


}

fun topic(title:String) {
    println()
    println("========= $title ============= ")
}

fun subtopic(title:String) {
    println()
    println("========= $title ")
}