package com.example.appkotlinprincipios

class MyNesteadAndInnerClass {

    private val one = 1

    private fun returnOne(): Int {
        return one
    }

    // Clase Anidada (Nested Class)
    class MyNesteadClass {
        fun sum(first: Int, second: Int): Int {
            return first + second
        }
    }

    // Clase Interna (Inner class)
    inner class MyInnerClass {
        fun sumTow(number:Int): Int {
            return number + one + returnOne()
        }
    }

}