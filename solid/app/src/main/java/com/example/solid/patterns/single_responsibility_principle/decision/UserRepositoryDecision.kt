package com.example.solid.patterns.single_responsibility_principle.decision

import com.example.solid.patterns.single_responsibility_principle.problem.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


sealed interface UserEvent {
    data object Initial : UserEvent
    data class UserUpdated(val user: User) : UserEvent
    data class UserCreated(val user: User) : UserEvent
    data class UserRemoved(val user: User) : UserEvent
}

interface UserRepository {
    fun save(user: User)
    fun update(user: User)
    fun delete(user: User)
}

interface Synchronizer {
    fun sync(userEvent: UserEvent)
}

interface UserEventObservable {
    fun observeSync(): StateFlow<UserEvent>
}

class UserRepositoryImpl : UserRepository, UserEventObservable {
    private val _updates = MutableStateFlow<UserEvent>(UserEvent.Initial)

    override fun save(user: User) {
        // insert/update data in the db
        _updates.value = UserEvent.UserCreated(user)
    }

    override fun update(user: User) {
        // insert/update data in the db
        _updates.value = UserEvent.UserUpdated(user)
    }

    override fun delete(user: User) {
        // insert/update data in the db
        _updates.value = UserEvent.UserRemoved(user)
    }

    override fun observeSync(): StateFlow<UserEvent> {
        return _updates
    }
}

class SynchronizerImpl : Synchronizer {
    override fun sync(userEvent: UserEvent) {
        when (userEvent) {
            is UserEvent.UserCreated -> {
                // send notification
            }

            is UserEvent.UserUpdated -> {
                // send notification
            }

            is UserEvent.UserRemoved -> {
                // send notification
            }

            UserEvent.Initial -> {
                // do nothing
            }
        }
    }
}

suspend fun main() {
    val userRepository: UserRepository = UserRepositoryImpl()
    val synchronizer: Synchronizer = SynchronizerImpl()

    subscribeToSyncUpdates(userRepository as UserEventObservable, synchronizer)

    userRepository.save(User(1, "John"))
}

suspend fun subscribeToSyncUpdates(observable: UserEventObservable, synchronizer: Synchronizer) {
    observable.observeSync().collect { event ->
        synchronizer.sync(userEvent = event)
    }
}
