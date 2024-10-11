package com.example.solid.patterns.interface_segregation_principle.desicion

interface ClickListener {
    fun onClick()
}

interface LongClickListener {
    fun onLongClick()
}

class ButtonClickListener : ClickListener {
    override fun onClick() {
        // SOME LOGIC ONLY HERE
    }
}

class CardClickListener : LongClickListener {
    override fun onLongClick() {
        // SOME LOGIC ONLY HERE
    }
}
