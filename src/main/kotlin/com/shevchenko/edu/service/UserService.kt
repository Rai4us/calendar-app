package com.shevchenko.edu.service

import com.shevchenko.edu.model.User

interface UserService {

    fun getUserById(id: Int?): User

    fun getAllUsers(): List<User>

    fun createUser(user: User): User

    fun updateUser(user: User): Boolean

    fun addEmail(id: Int?, email: String?)

}