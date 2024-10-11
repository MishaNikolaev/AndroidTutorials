package com.example.solid.patterns.interface_segregation_principle.problem


interface AdvancedMediaPlayer {
    fun playVlc(fileName: String)
    fun playMp4(fileName: String)
}

class VlcPlayer : AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        println("Playing vlc file. Name: $fileName")
    }

    override fun playMp4(fileName: String) {
        //do nothing
    }
}

class Mp4Player : AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        //do nothing
    }

    override fun playMp4(fileName: String) {
        println("Playing mp4 file. Name: $fileName")
    }
}