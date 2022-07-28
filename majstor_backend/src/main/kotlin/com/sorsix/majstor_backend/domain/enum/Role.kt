package com.sorsix.majstor_backend.domain.enum

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority {
    ROLE_CLIENT,ROLE_MASTER,ROLE_ADMIN;

    override fun getAuthority(): String {
        return name
    }
}