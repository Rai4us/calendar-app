package com.shevchenko.edu.controller

import com.shevchenko.edu.model.User
import com.shevchenko.edu.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/users")
class UserController(private var userService: UserService) {

    @GetMapping
    fun getAllUsers() : ResponseEntity<List<User>>{
        return ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/create")
    fun createUser(@RequestBody user: User) : ResponseEntity<User> {
        val createdUser = userService.createUser(user)
        return ResponseEntity(createdUser, HttpStatus.CREATED)
    }
}