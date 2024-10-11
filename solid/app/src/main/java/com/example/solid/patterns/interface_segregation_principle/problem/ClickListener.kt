package com.example.solid.patterns.interface_segregation_principle.problem


interface ClickListener {
    fun onClick()
    fun onLongClick()
}

class ButtonClickListener : ClickListener {
    override fun onClick() {
        // SOME LOGIC ONLY HERE
    }

    override fun onLongClick() {
        // NOT REQUIRED FOR THIS UI COMPONENT
    }
}

class LabelClickListener : ClickListener {
    override fun onClick() {
        // NOT REQUIRED FOR THIS UI COMPONENT
    }

    override fun onLongClick() {
        // SOME LOGIC ONLY HERE
    }
}