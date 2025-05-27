package com.example.pbkkallin1.data

data class User(
    val username: String,
    val email: String,
    val password: String
)

val Users = listOf(
    User("user 1", "user1@gmail.com", "password1"),
    User("user 2", "user2@gmail.com", "password2")
)