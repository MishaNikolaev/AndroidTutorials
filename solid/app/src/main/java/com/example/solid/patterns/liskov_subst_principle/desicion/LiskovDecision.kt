package com.example.solid.patterns.liskov_subst_principle.desicion


interface HasSquare {
    fun calculateSquare(): Int
}

class Rectangle(private val width: Int, private val height: Int) : HasSquare {
    override fun calculateSquare(): Int {
        return width * height
    }
}

class Square(private val side: Int) : HasSquare {

    override fun calculateSquare(): Int {
        return side * side
    }
}

class SquareCalculator {
    fun calculateSquare(squareable: HasSquare): Int {
        return squareable.calculateSquare()
    }
}
