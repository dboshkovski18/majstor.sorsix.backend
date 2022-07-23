package com.sorsix.majstor_backend.domain

import com.sorsix.majstor_backend.domain.enum.Gender
import com.sorsix.majstor_backend.domain.enum.MasterStatus
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

    var name: String,

    var surname: String,

    var phone_number: String,

    var email: String,

    var embg: Long,

    @Enumerated(value = EnumType.STRING)
    var gender: Gender,

    @Enumerated(value = EnumType.STRING)
    var type: MasterType,

    @Enumerated(value = EnumType.STRING)
    var status: MasterStatus

)