package com.shevchenko.edu.service.impl

import com.shevchenko.edu.model.User
import com.shevchenko.edu.repository.UserRepository
import com.shevchenko.edu.service.UserService
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Slf4j
@Service("userService")
class DefaultUserService(private val userRepository: UserRepository) : UserService {

    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun getUserById(id: Int?): User {
        return userRepository.findById(id!!).get()
    }

    override fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    override fun createUser(user: User): User {
        return userRepository.save(user)
    }

    override fun updateUser(user: User): Boolean {
        val userFromDb: User = userRepository.findById(user.id ?: throw IllegalArgumentException("User should have an id") ).get()
        userFromDb.name = user.name
        userFromDb.surname = user.surname
        userFromDb.emails?.addAll(user.emails!!)
        userRepository.save(userFromDb)
        return true
    }

    override fun addEmail(id: Int?, email: String?) {
        val user = getUserById(id)
        user.emails?.add(email!!)
        userRepository.save(user)
        log.info("User with id $id has been updated")
    }


}