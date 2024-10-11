package com.example.solid.patterns.single_responsibility_principle.problem

interface IOManager {
    fun saveFile()

    fun readFile()

    fun saveApi()

    fun readApi()

    fun saveToDb()

    fun readFromDb()
}

//This is bad decision to add many methods in one interface
