package com.example.patterns_clean_architecture.patterns


/** ALLOWS YOU TO DYNAMICALLY ADD NEW FUNCTIONALITY TO OBJECTS BY WRAPPING THEM IN USEFUL "WRAPPERS" */

interface DataSource<T> {
    fun writeData(data: T)
    fun readData(): T
}

abstract class CompressionDecorator<T>(private val source: DataSource<T>) : DataSource<T> {

    protected abstract fun compress(data: T): T

    protected abstract fun decompress(data: T): T
}

abstract class EncryptionDecorator<T>(private val source: DataSource<T>) : DataSource<T> {

    protected abstract fun encrypt(data: T): T

    protected abstract fun decrypt(data: T): T
}


class FileDataSource : DataSource<String> {

    override fun writeData(data: String) {
        println("Write data: $data")
    }

    override fun readData(): String {
        return "data"
    }
}

class FileCompressionDecorator(private val source: DataSource<String>) :
    CompressionDecorator<String>(source) {

    override fun writeData(data: String) {
        // 1. compress data
        val compressedData = compress(data)
        // 2. write data
        source.writeData(compressedData)
    }

    override fun readData(): String {
        // 1. read data
        val data = source.readData()
        // 2. decompress data
        return decompress(data)
    }

    override fun compress(data: String): String {
        // compression logic
        return "compressed data"
    }

    override fun decompress(data: String): String {
        // decompression logic
        return "decompressed data"
    }
}

class FileEncryptDecorator(private val source: DataSource<String>) :
    EncryptionDecorator<String>(source) {
    override fun writeData(data: String) {
        // 1. encrypt data
        val encryptedData = encrypt(data)
        // 2. write data
        source.writeData(encryptedData)
    }

    override fun readData(): String {
        // 1. read data
        val data = source.readData()
        // 2. decrypt data
        return decrypt(data)
    }

    override fun encrypt(data: String): String {
        // encryption logic
        return "encrypted data"
    }

    override fun decrypt(data: String): String {
        // decryption logic
        return "decrypted data"
    }
}

fun main() {
    val fileDataSource = FileDataSource()
    val fileCompressionDecorator = FileCompressionDecorator(fileDataSource)
    val fileEncryptDecorator = FileEncryptDecorator(fileCompressionDecorator)
    fileEncryptDecorator.writeData("data")
}
