package com.example.patterns_clean_architecture.patterns


/** ADAPTER - HELPS INCOMPATIBLE INTERFACES TO WORK TOGETHER */


interface MediaPlayer {
    fun play(audioType: String, fileName: String)
}

interface AdvancedMediaPlayer {
    fun playVlc(fileName: String)
    fun playMp4(fileName: String)
    fun playAvi(fileName: String)
    fun playMp3(fileName: String)
}

class AdvancedMediaPlayerImpl : AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        println("Playing vlc file. Name: $fileName")
    }

    override fun playMp4(fileName: String) {
        println("Playing mp4 file. Name: $fileName")
    }

    override fun playAvi(fileName: String) {
        println("Playing avi file. Name: $fileName")
    }

    override fun playMp3(fileName: String) {
        println("Playing mp3 file. Name: $fileName")
    }
}

class MediaAdapter : MediaPlayer {

    private val advancedMediaPlayer: AdvancedMediaPlayer

    init {
        advancedMediaPlayer = AdvancedMediaPlayerImpl()
    }

    override fun play(audioType: String, fileName: String) {
        when (audioType) {
            "vlc" -> advancedMediaPlayer.playVlc(fileName)
            "mp4" -> advancedMediaPlayer.playMp4(fileName)
            "avi" -> advancedMediaPlayer.playAvi(fileName)
            "mp3" -> advancedMediaPlayer.playMp3(fileName)
        }
    }
}


fun main() {
    val mediaApp = MediaAdapter()
    mediaApp.play("mp3", "beyond the horizon.mp3")
    mediaApp.play("mp4", "alone.mp4")
    mediaApp.play("vlc", "far far away.vlc")
    mediaApp.play("avi", "mind me.avi")
}