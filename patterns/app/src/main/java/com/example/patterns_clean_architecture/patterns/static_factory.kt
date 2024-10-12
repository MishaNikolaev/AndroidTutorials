package com.example.patterns_clean_architecture.patterns

/**
 * Static factory method
 */
class SomeObject private constructor(val name: String) {

    companion object{
        fun createWithName(name: String): SomeObject {
            return SomeObject(name)
        }
    }
}

fun main() {
    val someObject = SomeObject.createWithName("some name")
    println(someObject.name)
}

/**
 Also we can have a abstract fabric method.
 it contains creation of fabric (not methods).
 */
