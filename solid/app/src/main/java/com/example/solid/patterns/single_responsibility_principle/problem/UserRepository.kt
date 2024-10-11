package com.example.solid.patterns.single_responsibility_principle.problem


// We have a DAO class that is responsible for saving,
// updating and deleting data from the database.
// We also synchronize the data with the server.
data class User(val id: Int, val name: String)

class UserRepository {
    fun saveAndSync(user: User) {
        // save to db
        // sync data with the server
    }

    fun updateAndSync(user: User) {
        // update db
        // sync data with the server
    }

    fun deleteAndSync(user: User) {
        // delete from db
        // sync data with the server
    }
}