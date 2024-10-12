package com.example.patterns_clean_architecture.patterns


class Person private constructor(
    val name: String,
    val age: Int = 0,
    val height: Int = 0,
    val weight: Int = 0,
    val address: String = "",
    val phone: String = "",
    val email: String = "",
    val job: String = "",
    val position: String = "",
    val salary: Int = 0,
    val experience: Int = 0,
) {

    class Builder {
        private var name: String = ""
        private var age: Int = 0
        private var height: Int = 0
        private var weight: Int = 0
        private var address: String = ""
        private var phone: String = ""
        private var email: String = ""
        private var job: String = ""
        private var position: String = ""
        private var salary: Int = 0
        private var experience: Int = 0

        fun setName(name: String): Builder {
            this.name = name
            return this
        }

        fun setAge(age: Int): Builder {
            this.age = age
            return this
        }

        fun setHeight(height: Int): Builder {
            this.height = height
            return this
        }

        fun setWeight(weight: Int): Builder {
            this.weight = weight
            return this
        }

        fun setAddress(address: String): Builder {
            this.address = address
            return this
        }

        fun setPhone(phone: String): Builder {
            this.phone = phone
            return this
        }

        fun setEmail(email: String): Builder {
            this.email = email
            return this
        }

        fun setJob(job: String): Builder {
            this.job = job
            return this
        }

        fun setPosition(position: String): Builder {
            this.position = position
            return this
        }

        fun setSalary(salary: Int): Builder {
            this.salary = salary
            return this
        }

        fun setExperience(experience: Int): Builder {
            this.experience = experience
            return this
        }

        fun build(): Person {
            if (name.isEmpty()) throw IllegalArgumentException("Name is empty")
            if (age == 0) throw IllegalArgumentException("Age is empty")
            if (height == 0) throw IllegalArgumentException("Height is empty")
            if (weight == 0) throw IllegalArgumentException("Weight is empty")
            if (address.isEmpty()) throw IllegalArgumentException("Address is empty")
            if (phone.isEmpty()) throw IllegalArgumentException("Phone is empty")
            return Person(
                name, age, height, weight, address, phone, email, job, position, salary, experience
            )
        }
    }
}

fun main() {
    val person = Person.Builder()
        .setName("John")
        .setAge(25)
        .setHeight(180)
        .setWeight(80)
        .setAddress("Some address")
        .setPhone("Some phone")
        .setEmail("Some email")
        .setJob("Some job")
        .setPosition("Some position")
        .setSalary(1000)
        .setExperience(5)
        .build()
}