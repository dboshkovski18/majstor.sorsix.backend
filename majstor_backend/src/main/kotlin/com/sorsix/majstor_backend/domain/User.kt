package com.sorsix.majstor_backend.domain

import com.sorsix.majstor_backend.domain.enum.Role
import org.springframework.lang.Nullable
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true)
    private val username: String,

    @Column
    private val password: String,

    @Enumerated(EnumType.STRING)
    val role: Role,

    @Column(name="is_account_not_expired")
    private val isAccountNotExpired1: Boolean = true,

    @Column(name="is_account_non_locked")
    private val isAccountNonLocked1: Boolean = true,

    @Column(name="is_credentials_not_expired")
    private val isCredentialsNonExpired1: Boolean = true,

    @Column(name="is_enabled")
    private val isEnabled1: Boolean = true,

    @OneToOne
    @JoinColumn(name = "master_id")
    @Nullable
    private val master : Master? = null,

    @OneToOne
    @JoinColumn(name = "client_id")
    @Nullable
    private val client : Client? = null

) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return Collections.singletonList(role)
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return isAccountNotExpired1
    }

    override fun isAccountNonLocked(): Boolean {
        return isAccountNonLocked1
    }

    override fun isCredentialsNonExpired(): Boolean {
        return isCredentialsNonExpired1
    }

    override fun isEnabled(): Boolean {
        return isEnabled1
    }

    fun getMaster() : Master? {
        return master
    }

    fun getClient() : Client? {
        return client
    }
}