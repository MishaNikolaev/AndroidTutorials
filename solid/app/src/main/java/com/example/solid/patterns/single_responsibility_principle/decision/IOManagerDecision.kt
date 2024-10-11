package com.example.solid.patterns.single_responsibility_principle.decision

//It will be better to add many interfaces which depends on their own methods.

interface  FileIOManager{
    fun saveFile()
    fun readFile()
}

interface  ApiOManager{
    fun saveApi()
    fun readApi()
}

interface  DbIOManager{
    fun saveToDb()
    fun readFromDb()
}

/*
The principle of unified responsibility is as follows:
we do not have the right to make different methods in the same
class or interface.
 */