package com.teko.data

import com.teko.data.features.auth.AuthRepositoryImpl
import com.teko.domain.AccessToken
import com.teko.domain.User
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import junit.framework.Assert
import org.junit.Test

class AuthRepositoryImplTest {

    private val systemUnderTest: AuthRepositoryImpl = mockk()

    @Test
    fun login_ShouldCallFromRemoteSource() {
        val response = mockk<Pair<User, AccessToken>>(relaxed = true)
        every {
            systemUnderTest
                .login(any(), any(), any())
        } returns Single.just(response)

        systemUnderTest
            .login("email", "pass", false)

        verify(exactly = 1) {
            systemUnderTest
                .login(any(), any(), any())
        }
    }

    @Test
    fun login_ShouldReceiveDataFromRemoteSource() {

        val response = mockk<Pair<User, AccessToken>>(relaxed = true)
        every {
            systemUnderTest
                .login(any(), any(), any())
        } returns Single.just(response)

        val result = systemUnderTest
            .login("email", "pass", false)
            .blockingGet()

        Assert.assertEquals(
            result,
            response
        )
    }
}