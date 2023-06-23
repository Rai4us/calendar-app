package com.shevchenko.edu

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CalendarAppApplication {

    fun main(args: Array<String>) {
        runApplication<CalendarAppApplication>(*args)
    }
}