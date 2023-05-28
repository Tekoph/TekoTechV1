package com.teko.network

import com.teko.domain.AccessToken
import com.teko.domain.User
import com.teko.network.features.auth.AuthRemoteSourceImpl
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Test

class AuthRemoteSourceImplTest {

    private val systemUnderTest: AuthRemoteSourceImpl = mockk()

    @Test
    fun login_ShouldCallFromService() {
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
    fun login_ShouldReceiveDataFromService() {
        val response = mockk<Pair<User, AccessToken>>(relaxed = true)
        every {
            systemUnderTest
                .login(any(), any(), any())
        } returns Single.just(response)

        val result = systemUnderTest
            .login("email", "pass", false)
            .blockingGet()

        assertEquals(
            result,
            response
        )
    }
}
