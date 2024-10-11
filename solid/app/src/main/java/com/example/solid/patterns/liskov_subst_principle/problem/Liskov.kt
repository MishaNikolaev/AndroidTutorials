package com.example.solid.patterns.liskov_subst_principle.problem

/** In simple terms, this principle states that different classes should not inherit from each other.*/

open class Rectangle {
    protected var width: Int = 0
    protected var height: Int = 0

    open fun set_Width(width: Int) {
        this.width = width
    }

    open fun set_Height(height: Int) {
        this.height = height
    }

    fun calculateSquare(): Int {
        return width * height
    }
}

class Square : Rectangle() {

    override fun set_Width(width: Int) {
        super.set_Width(width)
        setSide(width)
    }

    override fun set_Height(height: Int) {
        this.width = height
        this.height = height
    }

    private fun setSide(side: Int) {
        super.width = side
        super.height = side
    }
}


class SquareCalculator {
    fun calculateSquare(shape: Rectangle): Int {
        return shape.calculateSquare()
    }
}


fun main() {
    val rectangle = Rectangle()
    rectangle.set_Height(5)
    rectangle.set_Width(10)

    val square = Square()
    square.set_Height(5)
    square.set_Width(10)

    val squareCalculator = SquareCalculator()
    squareCalculator.calculateSquare(rectangle)
    println("Rectangle square = ${squareCalculator.calculateSquare(rectangle)}")
    println("Square square = ${squareCalculator.calculateSquare(square)}")
}
