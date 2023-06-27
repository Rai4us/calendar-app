package com.shevchenko.edu.converter

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter


@Converter
class StringSetConverter : AttributeConverter<Set<String>, String> {

    override fun convertToDatabaseColumn(elements: Set<String>?): String {
        return elements?.joinToString(separator = ";") ?: throw IllegalArgumentException("Elements souldn't be null")
    }

    override fun convertToEntityAttribute(information: String?): Set<String> {
        val elements = information?.split(";") ?: throw IllegalArgumentException("Information should be null")
        return HashSet<String>(elements)
    }
}