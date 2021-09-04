package com.example.appkotlinprincipios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variablesYConstantes()
        //sentenciaIf()
        //mapas()
        //loops()
        //nullSafety()
        //funciones()
        //classes()
        nesteadAndInnerClasses()

    }


    /*
    * Aquí vamos a hablar de variables y constantes*/
    private fun variablesYConstantes() {

        // variables
        var myFirstVariable = "Hello world!"
        println(myFirstVariable)

        // Contantes
        val myFirstConstant = "Esta es una constante"
        println(myFirstConstant)
    }

    /*
    * Aquí vamos a hablar de tipos de datos (data types)*/
    private fun tiposDeDatos() {

        // String
        val myString:String = "Hola mundo"
        println(myString)

        // Enteros (Byte, Short, Int, Long)
        val myInt: Int = 1
        println(myInt)

        // Decimales (Float, double)
        val myFloat: Float = 1.4f
        val myDouble: Double = 1.6
        println(myFloat)
        println(myDouble)

        // Boolean (Bool)
        val myBool: Boolean = true
        print(myBool)

    }

    private fun sentenciaIf() {
        val myNumber = 15

        if(myNumber < 10) println("$myNumber es menor que 10")
        else println("$myNumber no es menor que 10")

    }

    fun sentenciaWhen() {
        // When con String
        val country = "España"

        when(country) {
            "España" -> {
                println("Estamos en España")
            }
            "Mexico" -> {
                println("Estamos en Mexico")
            }
        }

    }

    fun arrays() {

        val name = "Manuel"
        val surname = "Ramallo"
        val company = "Solutia"
        val age = "25"

        // Creación de un array

        val myArray:ArrayList<String> = ArrayList()

        // Añadir datos de uno en uno
        myArray.add(name)
        myArray.add(surname)
        myArray.add(company)
        myArray.add(age)

        println(myArray)

        // Añadir un conjunto de datos
        myArray.addAll(listOf("Hola", "Bienvenidos", "Adios"))

        println(myArray)

        // Acceso a datos
        val myCompany:String = myArray[2]
        println(myCompany)

        // Modificar datos
        myArray[5] = "Suscribete crack"
        println(myArray)

        // Eliminar datos
        myArray.removeAt(4)
        println(myArray)

        // Recorrer datos
        myArray.forEach {
            println(it)
        }

        // Otras operacionse
        println(myArray.count())

        myArray.clear()

        println(myArray.count())

        myArray.first()
        myArray.last()

        myArray.sort()
    }

    fun mapas() {
        var myMap: Map<String, Int> = mapOf()
        println(myMap)

        // Añadimos elementos
        myMap = mutableMapOf("Manuel" to 1, "Pedro" to 2, "Sara" to 5)
        println(myMap)

        // Añadir un solo valor sin eliminar lo anterior
        myMap["Ana"] = 7
        myMap.put("Maria", 8)

        println(myMap)

        // Acceso a datos
        println(myMap["Manuel"])

    }

    private fun loops() {
        // Bucles
        val myArray: List<String> = listOf("Hola", "Bievenido", "Adios")
        val myMap = mutableMapOf("Manuel" to 1, "Pedro" to 2, "Sara" to 5)

        // For
        for(myString in myArray) {
            println(myString)
        }

        for (myElement in myMap) {
            println("${myElement.key}-${myElement.value}}")
        }

        // Esto lo hace 11 veces, de 0 a 10
        for (x in 0..10) {
            println(x)
        }

        // Con esto no tiene en cuenta el ultimo valor, lo haría 10 veces solor
        for (x in 1 until 10) {
            println(x)
        }

        for(x in 1 until 20) {
            if( x % 2 == 0) {
                Log.d("TAG", "El número $x es par")
            }

            if( x % 3 == 0) {
                Log.d("TAG", "El número $x es multiplo de 3")
            }
        }


        // Para que vaya pintando de 2 en 2
        for (x in 0..10 step 2) {
            println(x)
        }

        // Para que vaya en cuenta atrás pero de 3 en 3 ( esto ultimo no hace falta, podria hacerse de 1 en 1 )
        for (x in 10 downTo 0 step 3) {
            println(x)
        }

        var myNumericArray = (0..20)
        println(myNumericArray)

        // while
        var x = 0

        while (x < 10) {
            x++
        }
    }


    /*
    * Vamos a ver el nullsafety para controlar los null pointer exception
    * Vamos a hablar de seguridad contra nulos (null safety)*/
    fun nullSafety() {
        var myString = "Manuel"
        //myString = null esto daría un error de compilación
        println(myString)

        var mySafetyString: String? = "Manuel null safety"
        mySafetyString = null
        println(mySafetyString)

        mySafetyString = "Suscribete"

        //println(mySafetyString)

        //if(mySafetyString != null) println(mySafetyString!!)

        // Safe calls ( esto es lo importante de usar null safety )

        println(mySafetyString?.length)

        // La interrogación la ponemos para que solo se ejecute si no es nulo
        // el it hace referencia al elemento del que se está llamando ( en este caso mySafetyString)
        // el ?: run es para controlar de que en el caso de que sea nulo haga algo
        // como el if else de toda la vida de dios pero mas corto

        // Con esto es para que sea mas seguro y no tengamos problemas de null pointers exception

        mySafetyString?.let {
            println(it)
        } ?: run {
            println(mySafetyString)
        }

    }

    /**
     * Aquí vamos a hablar de funciones */
    fun funciones() {

        sayHello()
        sayHello()
        sayHello()

        sayMyName("Manuel")
        sayMyName(null)

        sayMyNameAndAge("Manuel", 25)
        val sumResult = sumTwoNumbers(10, 15)
        println(sumResult)
    }

    // Función simple
    fun sayHello() {
        println("Hola!")
    }

    // Funciones con parametros de entrada
    fun sayMyName(nombre:String?) {
        println("Hola, mi nombre es $nombre")
    }

    // Funciones con mas de un parametro de entrada
    fun sayMyNameAndAge(nombre: String, edad:Int) {
        println("Hola, mi nombre es $nombre y mi edad es $edad")
    }

    // Funciones con un valor de retorno
    fun sumTwoNumbers(firstNumber:Int, secondNumber:Int):Int {
        val sum = firstNumber + secondNumber
        return sum
    }



    /**
     * Aquí vamos a ver las clases*/
    fun classes() {

        val manuel = Programmer("Manuel", 25, arrayOf(Programmer.Language.JAVA, Programmer.Language.KOTLIN))
        println(manuel.nombre)
        manuel.code()

        val sara = Programmer("Sara", 25, arrayOf(Programmer.Language.SWIFT), arrayOf(manuel))
        println(sara.friends?.first()?.nombre)
    }

    private fun nesteadAndInnerClasses() {

        val myNestedClass = MyNesteadAndInnerClass.MyNesteadClass()

        val sum = myNestedClass.sum(10, 5)
        println(sum)

        val myInnerClass = MyNesteadAndInnerClass().MyInnerClass()
        val sumTwo = myInnerClass.sumTow(10)
        println("El resultado de sumar dos es: $sumTwo")

    }

}