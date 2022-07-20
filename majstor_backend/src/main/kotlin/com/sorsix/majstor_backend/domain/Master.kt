package com.sorsix.majstor_backend.domain

import com.sorsix.majstor_backend.domain.enum.Gender
import com.sorsix.majstor_backend.domain.enum.MasterType
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "masters")
data class Master(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val surname: String,

    val phone_number: String,

    val email: String,

    val embg: Long,

    @Enumerated(value = EnumType.STRING)
    val gender: Gender,

    @Enumerated(value = EnumType.STRING)
    val type: MasterType

)