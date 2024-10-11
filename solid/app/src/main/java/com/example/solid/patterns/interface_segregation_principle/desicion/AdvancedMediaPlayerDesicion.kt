package com.example.solid.patterns.interface_segregation_principle.desicion

/** WE SHOULD NOT FORCE TO IMPLEMENT LOGIC THAT IS NOT REQUIRED */

interface AdvancedMediaPlayerMP4 {
    fun playMp4(fileName: String)
}

interface AdvancedMediaPlayerVLC {
    fun playVlc(fileName: String)
}

class VlcPlayer : AdvancedMediaPlayerVLC {
    override fun playVlc(fileName: String) {
        println("Playing vlc file. Name: $fileName")
    }
}

class Mp4Player : AdvancedMediaPlayerMP4 {

    override fun playMp4(fileName: String) {
        println("Playing mp4 file. Name: $fileName")
    }
}