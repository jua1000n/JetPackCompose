package com.kukis.cursojetpack.instagram.login.domain

import com.kukis.cursojetpack.instagram.login.data.LoginRepository
import javax.inject.Inject


class LoginUseCase @Inject constructor(private val repository: LoginRepository) {
    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }
}