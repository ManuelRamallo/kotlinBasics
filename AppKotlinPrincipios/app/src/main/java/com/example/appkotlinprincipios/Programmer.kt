package com.example.appkotlinprincipios

class Programmer(var nombre:String,
                 var edad:Int,
                 var languages:Array<Language>,
                 val friends: Array<Programmer>? = null) {

    enum class Language {
        KOTLIN,
        SWIFT,
        JAVA,
        JAVASCRIPT
    }


    fun code() {
        for( language in languages) {
            println("Estoy programando en $language")
        }

    }


}