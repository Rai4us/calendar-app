package com.shevchenko.edu.model

import com.shevchenko.edu.converter.StringSetConverter
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User {
    @Id
    @SequenceGenerator(name = "user_id_sequence", sequenceName = "user_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_sequence")
    var id: Int? = null
    @Convert(converter = StringSetConverter::class)
    var emails: MutableSet<String>? = null
    var name: String = ""
    var surname: String = ""
    var created: LocalDateTime = LocalDateTime.now()
    var updated: LocalDateTime = created
}