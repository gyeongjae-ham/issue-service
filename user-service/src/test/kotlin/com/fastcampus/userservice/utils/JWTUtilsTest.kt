package com.fastcampus.userservice.utils

import com.fastcampus.userservice.config.JWTProperties
import mu.KotlinLogging
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class JWTUtilsTest {

    private val log = KotlinLogging.logger {}

    @Test
    fun createTokenTest() {
        val claim = JWTClaim(
            userId = 1,
            email = "email",
            profileUrl = "profileUrl",
            username = "username",
        )

        val properties = JWTProperties(
            issuer = "issuer",
            subject = "subject",
            secret = "secret",
            expiresTime = 3600,
        )

        val token = JWTUtils.createToken(claim, properties)

        assertNotNull(token)

        log.info { "token: $token" }
    }

    @Test
    fun decodeTest() {
        val claim = JWTClaim(
            userId = 1,
            email = "email",
            profileUrl = "profileUrl",
            username = "username",
        )

        val properties = JWTProperties(
            issuer = "issuer",
            subject = "subject",
            secret = "secret",
            expiresTime = 3600,
        )

        val token = JWTUtils.createToken(claim, properties)

        val decode = JWTUtils.decode(token, properties.secret, properties.issuer)

        with(decode) {
            log.info { "claims : $claims" }
            val userId = claims["userId"]!!.asLong()
            assertEquals(userId, claim.userId)

            val email = claims["email"]!!.asLong()
            assertEquals(userId, claim.userId)

            val profileUrl = claims["profileUrl"]!!.asLong()
            assertEquals(userId, claim.userId)

            val username = claims["username"]!!.asLong()
            assertEquals(userId, claim.userId)
            userId
        }
    }
}
