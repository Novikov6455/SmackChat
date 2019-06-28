package com.example.smack.Tests

import android.support.test.filters.LargeTest
import com.example.smack.Screens.Lev02LoginScreen
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

@LargeTest
// @RunWith(AndroidJUnit4::class)
class SignUpTest02 : BaseTest() {

    @Test
    fun userSignUp() {
        val lev02LoginScreen: Lev02LoginScreen = startAppAndGoToLoginScreen()

        val toCreateUserName = "tester"
        val validCreatedUserName = (toCreateUserName + dateString())
        val toCreateUserEmail = "@test.com"
        val validCreatedUserEmail = dateString().plus(toCreateUserEmail)
        val validCreatedUserPassword = "654321"

        val lev03SignUpScreen = lev02LoginScreen.tapSignUpHereBtn()
        lev03SignUpScreen.enterUserName(validCreatedUserName)
        lev03SignUpScreen.enterUserEmail(validCreatedUserEmail)
        lev03SignUpScreen.enterUserPassword(validCreatedUserPassword)
        lev03SignUpScreen.tapAvatarImageViewBtn()
        lev03SignUpScreen.tapAvatarImageViewBtn()
        lev03SignUpScreen.tapAvatarImageViewBtn()
        lev03SignUpScreen.generateBackgroundColor()
        lev03SignUpScreen.generateBackgroundColor()
        lev03SignUpScreen.generateBackgroundColor()

        val lev03MainActivityScreen = lev03SignUpScreen.createUser()
        lev03MainActivityScreen.validUserNameIsDisplayed(validCreatedUserName)

        lev03MainActivityScreen.submitLogOut()
    }

    private fun dateString(): String {
        var convertedDate = Date()
        val outDateString = SimpleDateFormat("yyyyMMdd HH:mm:ss", Locale.getDefault())
        return outDateString.format(convertedDate)
    }
}